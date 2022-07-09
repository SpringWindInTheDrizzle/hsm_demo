package com.example.hsm_demo.service;


import com.example.hsm_demo.repository.po.DemoPo;

import java.util.List;

public interface DemoService {
    DemoPo getById(Long id);

    List<DemoPo> getAndLimitByAge(int age);
}
