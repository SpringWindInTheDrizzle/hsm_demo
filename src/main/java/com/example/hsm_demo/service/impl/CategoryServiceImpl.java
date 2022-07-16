package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.dto.CategoryDto;
import com.example.hsm_demo.repository.mapper.CategoryMapper;
import com.example.hsm_demo.repository.po.CategoryPo;
import com.example.hsm_demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> showAll() {
        //一个一级分类名字：所有二级分类
        //select * from A where type = 0 and level = 1
        List<CategoryPo> categoryPos = categoryMapper.selectList(new QueryWrapper<CategoryPo>()
                .lambda()
                .eq(CategoryPo::getType,0)
                .eq(CategoryPo::getLevel,1));
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (int i = 0; i < categoryPos.size(); i++) {
            CategoryDto categoryDto = turn(categoryPos.get(i));
            List<CategoryPo> categoryList = categoryMapper.selectList(new QueryWrapper<CategoryPo>()
                    .lambda()
                    .eq(CategoryPo::getType,0)
                    .eq(CategoryPo::getLevel,2)
                    .eq(CategoryPo::getParentId, categoryDto.getId()));
            categoryDto.setSubList(categoryList.stream().map(this::turn).collect(Collectors.toList()));
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    private CategoryDto turn(CategoryPo categoryPo) {
        return new CategoryDto()
                .setId(categoryPo.getId())
                .setLevel(categoryPo.getLevel())
                .setName(categoryPo.getName())
                .setType(categoryPo.getType());
    }
}
