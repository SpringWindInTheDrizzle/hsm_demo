package com.example.hsm_demo.service.impl;

import com.example.hsm_demo.repository.mapper.DemoMapper;
import com.example.hsm_demo.repository.po.DemoPo;
import com.example.hsm_demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public DemoPo getById(Long id) {
        return demoMapper.selectById(id);
    }
}
