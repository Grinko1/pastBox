package com.shortlinks.testtask.repository;

import com.shortlinks.testtask.entity.PastBoxEntity;

import java.util.List;

public interface PastBoxRepository {
    PastBoxEntity findByHash(String hash);
    List<PastBoxEntity> findAllByStatusAndALive(int amount);
    String save(PastBoxEntity pastBox);
}
