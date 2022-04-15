package com.autozone.pic.controller;

import com.autozone.pic.model.PRODUCT;

import com.autozone.pic.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
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

    @GetMapping(path = "count")
    @ResponseStatus(HttpStatus.OK)
    public Long countProducts(){
        return ProductsRepo.count();
    }
}