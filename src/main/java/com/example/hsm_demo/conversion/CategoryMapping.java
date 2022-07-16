package com.example.hsm_demo.conversion;
import com.example.hsm_demo.dto.CategoryDto;
import com.example.hsm_demo.vo.CategoryVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapping {
    @Mappings({})
    CategoryVo convertDtoToVo(CategoryDto source);
    List<CategoryVo> convertDtoToVo(List<CategoryDto> source);
}


