package com.shortlinks.testtask.controller;

import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.payload.PastBoxUrlResponse;
import com.shortlinks.testtask.payload.PastBoxRequest;

import java.util.List;

public interface PastBoxService {

    PastBoxResponse getByHash(String hash);
    List<PastBoxResponse> getLatestPasts(int amount);
    PastBoxUrlResponse save(PastBoxRequest payload);


}
