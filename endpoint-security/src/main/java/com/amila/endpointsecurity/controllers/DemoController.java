package com.amila.endpointsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/demo")
    public String demo(){
        return "demo ";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello ";
    }
}
