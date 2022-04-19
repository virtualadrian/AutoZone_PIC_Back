package com.autozone.pic.controller;

import com.autozone.pic.model.CATALOG;
import com.autozone.pic.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
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

//    @GetMapping(path = "find_by_date")
//    @ResponseStatus(HttpStatus.OK)
//    public List<PRODUCT> getProductByDate(@RequestParam(value = "days") Integer days){
//        return CatalogRepo.findAllByAzDataObject_AzMetaDataObject_SchemaNm(LocalDateTime.now().minusDays(days));
//    }

//    @Override
//    public List<CATALOG> findAllbyDate(int age) {
//        String statement = "select * from bucket_name where _class = 'com.mine.test.model.Person' and age>"+age;
//        SimpleN1qlQuery query = N1qlQuery.simple(statement);
//        List<Person> list=couchbaseTemplate.findByN1QL(query, Person.class);
//        return list;
//    }

}