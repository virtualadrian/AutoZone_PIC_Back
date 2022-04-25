package com.autozone.pic.controller;
import com.autozone.pic.model.CATALOG;
import com.autozone.pic.model.PRODUCT;
import com.autozone.pic.repository.CatalogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController{
    @Autowired
    private CatalogsRepo catalogsRepo;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCatalog(@RequestBody CATALOG catalog){
        catalogsRepo.save(catalog);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CATALOG> getAllCatalogs(){
        return catalogsRepo.findAll();
    }

    @GetMapping(path = "find_by_date_range")
    @ResponseStatus(HttpStatus.OK)
    public List<PRODUCT> findNByDateRange(@RequestParam(value = "days") Integer daysFromToday, @RequestParam(value = "schemaName") String schemaName){
        String dateTime = LocalDateTime.now().minusDays(daysFromToday).toString();
        String truncatedDateTime = dateTime.substring(0, dateTime.indexOf('T'));
        return catalogsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThanAndAzDataObject_AzMetaDataObject_SchemaNm(truncatedDateTime, schemaName);
    }

    @GetMapping(path = "find_count_by_date_range")
    @ResponseStatus(HttpStatus.OK)
    public Long findCountByDateRange(@RequestParam(value = "days") Integer daysFromToday, @RequestParam(value = "schemaName") String schemaName){
        String dateTime = LocalDateTime.now().minusDays(daysFromToday).toString();
        String truncatedDateTime = dateTime.substring(0, dateTime.indexOf('T'));
        return catalogsRepo.findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThanAndAzDataObject_AzMetaDataObject_SchemaNm(truncatedDateTime, schemaName).stream().count();
    }




}