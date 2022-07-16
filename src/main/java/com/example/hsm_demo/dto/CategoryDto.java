package com.example.hsm_demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.List;

@Data
@Accessors(chain = true)
public class CategoryDto {
    private Long id;
    private String name;
    private Integer type;
    private Integer level;
    private List<CategoryDto> subList;
}
