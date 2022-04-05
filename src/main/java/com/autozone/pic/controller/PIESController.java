package com.autozone.pic.controller;

import com.autozone.pic.model.PIES;
import com.autozone.pic.repository.PIESRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pies")
public  class PIESController{


   // CouchbaseServerDataAccessImp

    @Autowired
    private PIESRepo piesRepo;

    //@GetMapping(method=RequestMethod.GET, value="{id}")
  //  public String getPIES(@PathVariable String id) throws Exception{
   //     return couchbaseS;
   // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String savePIES(@RequestBody PIES pies){
        piesRepo.save(pies);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PIES> getAllPIES(){
        return piesRepo.findAll();
    }
}