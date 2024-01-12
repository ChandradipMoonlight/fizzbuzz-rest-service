package com.moonlight.fizzbuzz.dto;

import lombok.Data;

@Data
public class FizzBuzzStatistics {
    private FizzBuzzRequest mostUsedRequest;
    private Integer totalHits;
}
