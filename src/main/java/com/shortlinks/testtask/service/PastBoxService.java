package com.shortlinks.testtask.service;

import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.payload.PastBoxUrlResponse;
import com.shortlinks.testtask.payload.PastBoxRequest;

import java.util.List;

public interface PastBoxService {

    PastBoxResponse getByHash(String hash);
    List<PastBoxResponse> getLatestPasts();
    PastBoxUrlResponse save(PastBoxRequest payload);


}
