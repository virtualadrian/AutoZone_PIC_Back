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


    @GetMapping(path = "find_by_date_range")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> getProductCountByRange(@RequestParam(value = "days") Integer days){
       // System.out.println(LocalDateTime.now().minusDays(days));
       // System.out.println(days);
        return ProductsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(LocalDateTime.now().minusDays(days).toString());


    }

    @GetMapping(path = "find_by_date")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> getProductByDate(@RequestParam(value = "days") Integer days){
        String dateTime = LocalDateTime.now().minusDays(days).toString();
        String truncatedDateTime = dateTime.substring(0, dateTime.indexOf('T'));
        return ProductsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(truncatedDateTime);
    }


    @GetMapping(path = "count")
    @ResponseStatus(HttpStatus.OK)
    public Long getProductCount(){
        return ProductsRepo.count();
    }
}