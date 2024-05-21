package com.shortlinks.testtask.service;

import com.shortlinks.testtask.entity.PastBoxEntity;
import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.payload.PastBoxRequest;
import com.shortlinks.testtask.payload.PastBoxUrlResponse;
import com.shortlinks.testtask.payload.PublicStatus;
import com.shortlinks.testtask.repository.InMemoryPastBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PastBoxServiceImpl implements PastBoxService {

    @Value("${app.host}")
    private String host;

    private final InMemoryPastBoxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);


    @Override
    public PastBoxResponse getByHash(String hash) {
        PastBoxEntity byHash = repository.findByHash(hash);
        return new PastBoxResponse(byHash.getData());
    }

    @Override
    public List<PastBoxResponse> getLatestPasts() {
        return repository.findAllByStatusAndALive(10).stream()
                .map(i -> new PastBoxResponse(i.getData())).collect(Collectors.toList());

    }

    @Override
    public PastBoxUrlResponse save(PastBoxRequest payload) {
        int id = generateId();

        PastBoxEntity entity = new PastBoxEntity(id, payload.getData(),
                LocalDateTime.now().plusSeconds(payload.getExpirationTimeSeconds()),
                        payload.getStatus());
        repository.save(entity);
        return new PastBoxUrlResponse(host + "/" + entity.getUuid());
    }

    private int generateId() {
        return idGenerator.incrementAndGet();
    }
}
