package org.jobapplication.springbootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@GetMapping("/")
public String getHello(){
    return "Hello there I am working";
}
@GetMapping("/ping")
    public String getPing(){
    return "pong";
}
}
