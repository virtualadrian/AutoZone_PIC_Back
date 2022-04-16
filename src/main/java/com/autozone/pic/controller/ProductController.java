package com.autozone.pic.controller;

import com.autozone.pic.model.PRODUCT;
import com.autozone.pic.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {



    @Autowired
    private ProductsRepo ProductsRepo;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProduct(@RequestBody PRODUCT product){
        ProductsRepo.save(product);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> getAllProducts(){
        return ProductsRepo.findAll();
    }


    @GetMapping(path = "countbydaterange")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> getProductCount(@RequestParam(value = "days") Integer days){
        System.out.println(LocalDateTime.now().minusDays(days));
        System.out.println(days);
        return ProductsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(LocalDateTime.now().minusDays(days));


    }

    @GetMapping(path = "countall")
    @ResponseStatus(HttpStatus.OK)
    public Long countProducts(){
        return ProductsRepo.count();
    }
}