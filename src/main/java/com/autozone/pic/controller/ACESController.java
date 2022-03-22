package com.autozone.pic.controller;

import com.autozone.pic.model.ACES;
import com.autozone.pic.model.PIES;
import com.autozone.pic.repository.ACESRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aces")
public  class ACESController{

    @Autowired
    private ACESRepo acesRepo;

    public String getACES(){
        return "";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveACES(@RequestBody ACES aces){
        acesRepo.save(aces);
        return "saved";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ACES> getAllACES(){
        return acesRepo.findAll();
    }
}