package com.shortlinks.testtask.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PastBoxRequest {
    private String data;
    private Long expirationTimeSeconds;
    private PublicStatus status;
}
