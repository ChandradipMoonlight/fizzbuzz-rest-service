package com.moonlight.fizzbuzz.controller;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import com.moonlight.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v2/fizzbuzz")
public class ReactiveFizzBuzzController {
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping(value = "/encode", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getFizzBuzzAlgo(@RequestParam(defaultValue = "3") int int1,
                                @RequestParam(defaultValue = "5") int int2,
                                @RequestParam(defaultValue = "10") int limit,
                                @RequestParam(defaultValue = "fizz") String str1,
                                @RequestParam(defaultValue = "buzz") String str2) {
        FizzBuzzRequest fizzBuzzRequest = new FizzBuzzRequest(int1, int2, limit, str1, str2);
        return fizzBuzzService.getAsyncEncryptedResultUsingFizzBuzzAlgorithm(fizzBuzzRequest);
    }

    @GetMapping(value = "/statistic")
    public Mono<Map<String, Object>> getStatistics() {
        return fizzBuzzService.getAsyncStatistics();
    }

}
