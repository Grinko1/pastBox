package com.shortlinks.testtask.repository;

import com.shortlinks.testtask.entity.PastBoxEntity;
import com.shortlinks.testtask.exception.NotFoundPastBoxException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryPastBoxRepository implements PastBoxRepository {
    private final Map<String, PastBoxEntity> pastBoxList = new ConcurrentHashMap<>();


    @Override
    public PastBoxEntity findByHash(String hash) {
        PastBoxEntity pastBox = pastBoxList.get(hash);
        if (pastBox == null){
            throw new NotFoundPastBoxException("Past box not found by hash=%s".formatted(hash));
        }
        return pastBox ;
    }

    @Override
    public List<PastBoxEntity> findAllByStatusAndALive(int amount) {
        LocalDateTime now = LocalDateTime.now();

        return pastBoxList.values().stream().filter(PastBoxEntity::isPublic)
                .filter(pastBox -> pastBox.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(PastBoxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());

    }

    @Override
    public String save(PastBoxEntity pastBox) {
        String hash =pastBox.getHash();
         pastBoxList.put(hash, pastBox);
        System.out.println(pastBoxList);
        System.out.println(hash +" get hash from created object");
        return hash;
    }
}
