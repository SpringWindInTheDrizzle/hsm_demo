package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.repository.mapper.CatMapper;
import com.example.hsm_demo.repository.mapper.ConfigMapper;
import com.example.hsm_demo.repository.po.CatPo;
import com.example.hsm_demo.repository.po.ConfigPo;
import com.example.hsm_demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private CatMapper catMapper;

    @Override
    public List<CatPo> listRecommandCats() {
        List<ConfigPo> configList = configMapper.selectList(new QueryWrapper<ConfigPo>().lambda()
                .eq(ConfigPo::getType, 1)
        );
        List<Long> catIdList = configList.stream().map(ConfigPo::getRelateId).collect(Collectors.toList());
        List<CatPo> catList = catMapper.selectBatchIds(catIdList);
        Map<Long, Integer> sortMap = new HashMap<>();
        for (int i = 0; i < configList.size(); i++) {
            ConfigPo config = configList.get(i);
            sortMap.put(config.getRelateId(), config.getSortValue());
        }
        catList.sort(Comparator.comparingInt(a -> sortMap.get(a.getId())));
        return catList;
    }
}
