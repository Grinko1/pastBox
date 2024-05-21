package com.shortlinks.testtask.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/")
public class PasteBoxRestController {

    @GetMapping
    public String get(){
        return "Some hash will be here";
    }
}
