package com.autozone.pic.controller;

import com.autozone.pic.model.CATALOG;
import com.autozone.pic.model.PRODUCT;
import com.autozone.pic.repository.CatalogRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalog")
public  class CatalogController{

    @Autowired
    private CatalogRepo CatalogRepo;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCatalog(@RequestBody CATALOG CATALOG){
        CatalogRepo.save(CATALOG);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CATALOG> getCatalog(){
        return CatalogRepo.findAll();
    }
}