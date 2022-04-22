package com.autozone.pic.controller;

import com.autozone.pic.model.CATALOG;
import com.autozone.pic.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping(path = "find_notes_by_date")
    @ResponseStatus(HttpStatus.OK)
    public List<CATALOG> findNotesByDateRange(@RequestParam(value = "days") Integer daysFromToday){
        return CatalogRepo.findAllAppsByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(LocalDateTime.now().minusDays(daysFromToday).toString());
    }

//    @GetMapping(path = "find_apps_by_date")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CATALOG> findAppsByDateRange(@RequestParam(value = "days") Integer daysFromToday){
//        return CatalogRepo.findAllAppsByAzDataObject_AzMetaDataObject_EqualsAndLastMaintainTsGreaterThan("productCatalogFitment",LocalDateTime.now().minusDays(daysFromToday).toString());
//    }



}