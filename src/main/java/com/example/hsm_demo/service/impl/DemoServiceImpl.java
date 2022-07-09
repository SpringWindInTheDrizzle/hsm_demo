package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.repository.mapper.DemoMapper;
import com.example.hsm_demo.repository.po.DemoPo;
import com.example.hsm_demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public DemoPo getById(Long id) {
        return demoMapper.selectById(id);
    }

    @Override
    public List<DemoPo> getAndLimitByAge(int age) {
        /**
         * xml方式写sql
         * return demoMapper.geAge(age);
         */
        if(age < 0){
            throw new RuntimeException("参数传错了，年龄不能为负数！");
        }
        return demoMapper.selectList(new QueryWrapper<DemoPo>().lambda().ge(DemoPo::getAge,age));
        //select * from Table demo where age >= age;
    }


}
