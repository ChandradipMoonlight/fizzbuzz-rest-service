package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface FizzBuzzService {

    Flux<String> getEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest);

    Mono<Map<String, Object>> getStatistics();
}