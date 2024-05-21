package com.shortlinks.testtask.service;

import com.shortlinks.testtask.controller.PastBoxService;
import com.shortlinks.testtask.entity.PastBoxEntity;
import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.payload.PastBoxRequest;
import com.shortlinks.testtask.payload.PastBoxUrlResponse;
import com.shortlinks.testtask.repository.InMemoryPastBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PastBoxServiceImpl implements PastBoxService {
    private final InMemoryPastBoxRepository repository;


    @Override
    public PastBoxResponse getByHash(String hash) {
        PastBoxEntity byHash = repository.findByHash(hash);
        return null;
    }

    @Override
    public List<PastBoxResponse> getLatestPasts(int amount) {
        List<PastBoxEntity> allByStatusAndALive = repository.findAllByStatusAndALive(10);
        return null;
    }

    @Override
    public PastBoxUrlResponse save(PastBoxRequest payload) {
        return null;
    }
}
