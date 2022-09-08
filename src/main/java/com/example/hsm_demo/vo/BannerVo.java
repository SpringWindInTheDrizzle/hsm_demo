package com.example.hsm_demo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BannerVo {

    private Long id;

    private String image;

    private String link;
}

