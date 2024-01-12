package com.moonlight.fizzbuzz.controller;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import com.moonlight.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/fizzbuzz")
public class FizzBuzzController {
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping(value = "/encode")
    public Flux<String> getFizzBuzzAlgo(@RequestParam(defaultValue = "3") int int1,
                                @RequestParam(defaultValue = "5") int int2,
                                @RequestParam(defaultValue = "100") int limit,
                                @RequestParam(defaultValue = "fizz") String str1,
                                @RequestParam(defaultValue = "buzz") String str2) {
        FizzBuzzRequest fizzBuzzRequest = new FizzBuzzRequest(int1, int2, limit, str1, str2);
        return fizzBuzzService.getEncryptedResultUsingFizzBuzzAlgorithm(fizzBuzzRequest);
    }

    @GetMapping(value = "/statistic")
    public Mono<Map<String, Object>> getStatistics() {
        return fizzBuzzService.getStatistics();
    }

}
