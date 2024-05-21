package com.shortlinks.testtask.controller;


import com.shortlinks.testtask.payload.PastBoxRequest;
import com.shortlinks.testtask.service.PastBoxServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/")
public class PasteBoxRestController {
    private final PastBoxServiceImpl pastService;
    @GetMapping
    public List<String> getLatestPasts(){
        List<String> response = new ArrayList<>();
        response.add("First past");
        response.add("Second past");
        response.add("Third past");
        response.add("Four past");
        return response;
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable("hash") String hash){
//        service.findByHash(hash)
        return hash;
    }
    @PostMapping
    public String createNewPast(@RequestBody PastBoxRequest payload){
        //return dto with past, generated link and expiration time
        return payload.getData();
    }
}
