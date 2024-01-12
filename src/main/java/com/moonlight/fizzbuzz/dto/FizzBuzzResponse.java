package com.moonlight.fizzbuzz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FizzBuzzResponse {
    private String message;
    private Object data;
}
