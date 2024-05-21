package com.shortlinks.testtask.entity;

import com.shortlinks.testtask.payload.PublicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class PastBoxEntity {
    private final UUID uuid;
    private int id;
    private String data;
    private LocalDateTime lifetime;
    private PublicStatus status;
    public PastBoxEntity(int id, String data, LocalDateTime expirationTime, PublicStatus status) {
        this.uuid = UUID.randomUUID();
        this.id = id;
        this.data = data;
        this.lifetime = expirationTime;
        this.status = status;
    }

}
