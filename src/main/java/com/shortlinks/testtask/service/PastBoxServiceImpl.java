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
        return new PastBoxResponse(byHash.getData(), byHash.isPublic());
    }

    @Override
    public List<PastBoxResponse> getLatestPasts(int amount) {
        return repository.findAllByStatusAndALive(10).stream()
                .map(i -> new PastBoxResponse(i.getData(), i.isPublic())).collect(Collectors.toList());

    }

    @Override
    public PastBoxUrlResponse save(PastBoxRequest payload) {
        int hash = generateId();
        PastBoxEntity entity = new PastBoxEntity();
        entity.setData(payload.getData());
        entity.setId(hash);
        entity.setPublic(payload.getStatus() == PublicStatus.PUBLIC);
        entity.setHash(Integer.toHexString(hash));
        entity.setLifetime(LocalDateTime.now().plusSeconds(payload.getExpirationTimeSeconds()));
        System.out.println(entity  + "  " + entity.hashCode());
        System.out.println(hash);
        repository.save(entity);
        return new PastBoxUrlResponse(host + "/" + entity.getHash());
    }

    private int generateId() {
        return idGenerator.incrementAndGet();
    }
}
