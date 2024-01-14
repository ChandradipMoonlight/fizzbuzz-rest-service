package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;

import java.util.List;
import java.util.Map;

public interface FizzBuzzService {
    List<String> getEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest);
    Map<String, Object> getStatistics();
}
