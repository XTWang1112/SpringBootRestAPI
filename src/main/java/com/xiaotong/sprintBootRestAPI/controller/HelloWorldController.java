package com.xiaotong.sprintBootRestAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //HTTP GET request
    @GetMapping("hello-world")
    public String hellWorld(){
        return "Hello World!";
    }
}
