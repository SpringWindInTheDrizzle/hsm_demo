package com.example.hsm_demo.controller;
import com.example.hsm_demo.conversion.CategoryMapping;
import com.example.hsm_demo.service.CategoryService;
import com.example.hsm_demo.vo.IndexVo;
import com.example.hsm_demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/index")
public class IndexController {


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapping categoryMapping;

    @GetMapping
    public Response<IndexVo> index() {
        IndexVo indexVo = new IndexVo();
        try{
            return new Response<>(indexVo.setCategoryVos(categoryMapping.convertDtoToVo(categoryService.showAll())));
        }catch(Exception e){
            return new Response<IndexVo>().setCode(101).setMessage(e.toString());
        }
    }


}
