package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import com.moonlight.fizzbuzz.dto.FizzBuzzResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface FizzBuzzService {

    Flux<String> getAsyncEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest);
    List<String> getEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest);

    Mono<Map<String, Object>> getAsyncStatistics();
    Map<String, Object> getStatistics();
}