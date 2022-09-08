package com.example.hsm_demo.conversion;

import com.example.hsm_demo.repository.po.CatPo;
import com.example.hsm_demo.vo.CatVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapping {

    @Mappings({})
    CatVo convertDtoToVo(CatPo source);

    List<CatVo> convertDtoToVo(List<CatPo> source);
}
