package com.example.hsm_demo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class IndexVo {
    private List<BannerVo> bannerVos;
    private List<CategoryVo> categoryVos;
    private List<CatVo> recommendVos;
}
