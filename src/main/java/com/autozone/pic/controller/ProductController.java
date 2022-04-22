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
    private ProductsRepo productsRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProduct(@RequestBody PRODUCT product){
        productsRepo.save(product);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> getAllProducts(){
        return productsRepo.findAll();
    }

    @GetMapping(path = "find_by_date_range")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> findByDateRange(@RequestParam(value = "days") Integer daysFromToday){
        return productsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(LocalDateTime.now().minusDays(daysFromToday).toString());
    }

    @GetMapping(path = "find_count_by_date_range")
    @ResponseStatus(HttpStatus.OK)
    public Long findCountByDateRange(@RequestParam(value = "days") Integer daysFromToday){
        return productsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(LocalDateTime.now().minusDays(daysFromToday).toString()).stream().count();
    }

    @GetMapping(path = "find_by_date")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> findByDate(@RequestParam(value = "days") Integer daysFromToday){
        String dateTime = LocalDateTime.now().minusDays(daysFromToday).toString();
        String truncatedDateTime = dateTime.substring(0, dateTime.indexOf('T'));
        return productsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(truncatedDateTime);
    }

    @GetMapping(path = "find_by_date_and_schema")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> findByDateAndSchemaName(@RequestParam(value = "days") Integer daysFromToday, @RequestParam(value = "schemaName") String schemaName){
        String dateTime = LocalDateTime.now().minusDays(daysFromToday).toString();
        String truncatedDateTime = dateTime.substring(0, dateTime.indexOf('T'));
        return productsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThanAndAzDataObject_AzMetaDataObject_SchemaNm(truncatedDateTime, schemaName);
    }

    @GetMapping(path = "find_count_by_date")
    @ResponseStatus(HttpStatus.OK)
    public Long findCountByDate(@RequestParam(value = "days") Integer daysFromToday){
        return findByDate(daysFromToday).stream().count();
    }


    @GetMapping(path = "count")
    @ResponseStatus(HttpStatus.OK)
    public Long getProductCount(){
        return productsRepo.count();
    }
}