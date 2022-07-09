package com.example.hsm_demo.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsm_demo.repository.po.DemoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper中基本的接口都有，sql已经实现，不用自己写
 * 一般的MVC流程：controller_service_dao_sql
 */
public interface DemoMapper extends BaseMapper<DemoPo> {

    List<DemoPo> geAge(@Param("nianling") int age);

}
