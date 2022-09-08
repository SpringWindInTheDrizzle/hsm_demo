package com.example.hsm_demo.controller;
import com.example.hsm_demo.conversion.BannerMapping;
import com.example.hsm_demo.conversion.CatMapping;
import com.example.hsm_demo.conversion.CategoryMapping;
import com.example.hsm_demo.service.BannerService;
import com.example.hsm_demo.service.CatService;
import com.example.hsm_demo.service.CategoryService;
import com.example.hsm_demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class IndexController {


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapping categoryMapping;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerMapping bannerMapping;

    @Autowired
    private CatService catService;

    @Autowired
    private CatMapping catMapping;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    @RequestMapping("/index")
    public Response<IndexVo> index() {
        IndexVo cacheIndex = (IndexVo) redisTemplate.opsForValue().get("index");
        if (cacheIndex != null) {
            return Response.success(cacheIndex);
        }
        IndexVo indexVo = new IndexVo();
        List<CategoryVo> categoryVoList = categoryMapping.convertDtoToVo(categoryService.showAll());
        List<BannerVo> bannerVoList = bannerMapping.convertDtoToVo(bannerService.listIndexBanners());
        List<CatVo> catVoList = catMapping.convertDtoToVo(catService.listRecommandCats());
        indexVo.setCategoryVos(categoryVoList).setBannerVos(bannerVoList).setRecommendVos(catVoList);
        redisTemplate.opsForValue().set("index", indexVo, 10, TimeUnit.MINUTES);
        return Response.success(indexVo);
    }
}
