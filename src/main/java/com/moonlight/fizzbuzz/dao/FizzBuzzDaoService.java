package com.moonlight.fizzbuzz.dao;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface FizzBuzzDaoService {
    void updateFrequencyOfFizzBuzzRequest(FizzBuzzRequest fizzBuzzRequest);

    Map<FizzBuzzRequest, Integer> getFrequencyOfFizzBuzzRequest();
}
