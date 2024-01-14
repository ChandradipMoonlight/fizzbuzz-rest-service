package com.moonlight.fizzbuzz.controller;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import com.moonlight.fizzbuzz.dto.FizzBuzzResponse;
import com.moonlight.fizzbuzz.service.FizzBuzzReactiveService;
import com.moonlight.fizzbuzz.service.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/fizzbuzz")
@Slf4j
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping(value = "/encode")
    public ResponseEntity<FizzBuzzResponse> getFizzBuzzAlgo(@RequestParam(defaultValue = "3") int int1,
                                                            @RequestParam(defaultValue = "5") int int2,
                                                            @RequestParam(defaultValue = "10") int limit,
                                                            @RequestParam(defaultValue = "fizz") String str1,
                                                            @RequestParam(defaultValue = "buzz") String str2) {
        FizzBuzzRequest fizzBuzzRequest = new FizzBuzzRequest(int1, int2, limit, str1, str2);
        log.debug("Inside class[FizzBuzzController] method[getFizzBuzzAlgo] FizzBuzzRequest : ", fizzBuzzRequest);
        List<String> result = fizzBuzzService.getEncryptedResultUsingFizzBuzzAlgorithm(fizzBuzzRequest);
        log.debug("Inside class[FizzBuzzController] method[getFizzBuzzAlgo] Result : ", result);
        return ResponseEntity.ok().body(new FizzBuzzResponse("Success", result));
    }

    @GetMapping(value = "/statistic")
    public ResponseEntity<FizzBuzzResponse> getStatistics() {
        Map<String, Object> statistics = fizzBuzzService.getStatistics();
        return ResponseEntity.ok().body(new FizzBuzzResponse("Success", statistics));
    }
}
