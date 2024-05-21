package com.shortlinks.testtask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastBoxResponse {
    private String data;
    private boolean isPublic;
}
