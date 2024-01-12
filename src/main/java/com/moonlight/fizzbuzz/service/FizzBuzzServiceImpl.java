package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dao.FizzBuzzDaoService;
import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{

    @Autowired
    private FizzBuzzDaoService fizzBuzzDaoService;
    @Override
    public Flux<String> getEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest) {
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(fizzBuzzRequest);
        return Flux.defer(() ->
                Flux.range(1, fizzBuzzRequest.getLimit())
                        .map(number -> convertToString(number, fizzBuzzRequest))
        );
    }

    @Override
    public Mono<Map<String, Object>> getStatistics() {
        return Mono.defer(() ->
                Mono.justOrEmpty(fizzBuzzDaoService.getFrequencyOfFizzBuzzRequest()
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(entry -> Map.of("most used request", entry.getKey(), "most frequent request", entry.getValue()))
                        .orElse(null)
                )
        );
    }

    private String convertToString(Integer number, FizzBuzzRequest fizzBuzzRequest) {
        if (number% fizzBuzzRequest.getInt1() == 0 && number % fizzBuzzRequest.getInt2() == 0) {
            return fizzBuzzRequest.getStr1() + fizzBuzzRequest.getStr2();
        } else if (number% fizzBuzzRequest.getInt1() == 0) {
            return fizzBuzzRequest.getStr1();
        } else if (number % fizzBuzzRequest.getInt2() == 0) {
            return fizzBuzzRequest.getStr2();
        } else {
            return String.valueOf(number);
        }
    }
}
