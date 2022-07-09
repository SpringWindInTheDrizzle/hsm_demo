package com.example.hsm_demo.service;


import com.example.hsm_demo.repository.po.DemoPo;

public interface DemoService {
    DemoPo getById(Long id);
}
