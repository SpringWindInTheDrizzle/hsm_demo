package com.example.hsm_demo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class CatVo {

    private Long id;

    private String name;

    private Long merchantId;

    private String merchantName;

    private String planetId;

    private String planetName;

    private Byte sex;

    private Integer age;

    private Integer nucleicStatus;

    private String price;

    private String introduction;
}
