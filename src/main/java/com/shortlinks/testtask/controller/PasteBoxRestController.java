package com.shortlinks.testtask.controller;


import com.shortlinks.testtask.payload.PastBoxRequest;
import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.payload.PastBoxUrlResponse;
import com.shortlinks.testtask.service.PastBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteBoxRestController {
    private final PastBoxService pastService;
    @GetMapping
    public List<PastBoxResponse> getLatestPasts(){
        return pastService.getLatestPasts(10);
    }

    @GetMapping("/{hash}")
    public PastBoxResponse getByHash(@PathVariable("hash") String hash){
    return pastService.getByHash(hash);

    }
    @PostMapping
    public PastBoxUrlResponse createNewPast(@RequestBody PastBoxRequest payload){
        return pastService.save(payload);
    }
}
