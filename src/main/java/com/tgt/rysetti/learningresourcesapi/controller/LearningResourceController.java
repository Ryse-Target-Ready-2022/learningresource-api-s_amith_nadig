package com.tgt.rysetti.learningresourcesapi.controller;


import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetti.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learningresources/v1")
public class LearningResourceController {
    @Autowired
    LearningResourceService learningResourceService;

    @GetMapping("/")
    public List<LearningResource> getALLlearningResources(){

        System.out.println("Testing the Controller Layer Test - GetAllResources");
        return learningResourceService.getLearningResources();
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources){
        System.out.println("Testing the Controller Layer Test - SaveResources");
        learningResourceService.saveLearningResources(learningResources);
    }
    @DeleteMapping(value = "/learningresource/{learningResourceId}")
    public void deleteLearningResource(@PathVariable int learningResourceId){
        System.out.println("Testing the Controller Layer Test - Delete-Resources");
        learningResourceService.deleteLearningResourceById(learningResourceId);
    }
}
