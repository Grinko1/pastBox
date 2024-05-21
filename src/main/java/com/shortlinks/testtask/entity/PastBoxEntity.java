package com.shortlinks.testtask.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@EqualsAndHashCode
public class PastBoxEntity {
    private int id;
    private String data;
    private LocalDateTime lifetime;
    private boolean isPublic;
    private String hash;


}
