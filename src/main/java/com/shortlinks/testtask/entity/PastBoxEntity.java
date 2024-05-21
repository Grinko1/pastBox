package com.shortlinks.testtask.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PastBoxEntity {
    private int id;
    private String data;
    private LocalDateTime lifetime;
    private boolean isPublic;
    private String hash;
}
