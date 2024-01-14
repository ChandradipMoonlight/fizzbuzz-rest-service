package com.moonlight.fizzbuzz.dao;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzDaoServiceImplTest {

    private FizzBuzzDaoService fizzBuzzDaoService;

    @BeforeEach
    void setUp() {
        fizzBuzzDaoService = new FizzBuzzDaoServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateFrequencyOfFizzBuzzRequest() {
        FizzBuzzRequest request = new FizzBuzzRequest(3, 5, 15, "fizz", "buzz");
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(request);
        Map<FizzBuzzRequest, Integer> frequencyOfFizzBuzzRequest = fizzBuzzDaoService.getFrequencyOfFizzBuzzRequest();
        assertEquals(1, frequencyOfFizzBuzzRequest.getOrDefault(request, 0));
    }

    @Test
    void getFrequencyOfFizzBuzzRequest() {
        FizzBuzzRequest request1 = new FizzBuzzRequest(3, 5, 15, "fizz", "buzz");
        FizzBuzzRequest request2 = new FizzBuzzRequest(2, 3, 10, "fizz", "buzz");
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(request1);
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(request2);
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(request1);
        Map<FizzBuzzRequest, Integer> frequencyMap = fizzBuzzDaoService.getFrequencyOfFizzBuzzRequest();
        assertEquals(1, frequencyMap.getOrDefault(request2, 0));
        assertEquals(2, frequencyMap.getOrDefault(request1, 0));
    }
}