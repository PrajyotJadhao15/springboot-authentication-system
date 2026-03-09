package com.system.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class Test {

    @GetMapping("/test")
    public String test(){
        return "Authorize user";
    }
}
