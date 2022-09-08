package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.repository.mapper.BannerMapper;
import com.example.hsm_demo.repository.po.BannerPo;
import com.example.hsm_demo.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerPo> listIndexBanners() {
        List<BannerPo> list = bannerMapper.selectList(new QueryWrapper<>());
        list.sort(Comparator.comparingInt(BannerPo::getSortValue));
        return list;
    }
}
