package com.example.bot;

import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/")
    public String sayHi() {
        return "HI";
    }
}
