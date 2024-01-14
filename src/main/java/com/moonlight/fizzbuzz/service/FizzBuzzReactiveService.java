package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface FizzBuzzReactiveService {

    Flux<String> getAsyncEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest);

    Mono<Map<String, Object>> getAsyncStatistics();

}