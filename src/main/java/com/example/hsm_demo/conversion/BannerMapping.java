package com.example.hsm_demo.conversion;

import com.example.hsm_demo.dto.CategoryDto;
import com.example.hsm_demo.repository.po.BannerPo;
import com.example.hsm_demo.vo.BannerVo;
import com.example.hsm_demo.vo.CategoryVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BannerMapping {
    @Mappings({})
    BannerVo convertDtoToVo(BannerPo source);
    List<BannerVo> convertDtoToVo(List<BannerPo> source);
}
