package com.moonlight.fizzbuzz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzzRequest {
    private Integer int1;
    private Integer int2;
    private Integer limit;
    private String str1;
    private String str2;
}
