package com.springcloud.controller;

import com.springcloud.entities.Eknown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEknownController {
    @Autowired
    private Eknown eknown;
    @GetMapping(value = "/getEknown")
    public String getEknown(){
        return "name : " + eknown.getName() + "email : " + eknown.getEmail();
    }
}
