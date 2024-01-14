package com.moonlight.fizzbuzz.controller;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import com.moonlight.fizzbuzz.dto.FizzBuzzResponse;
import com.moonlight.fizzbuzz.service.FizzBuzzService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FizzBuzzControllerTest {

    @Mock
    private FizzBuzzService fizzBuzzService;

    @InjectMocks
    private FizzBuzzController fizzBuzzController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFizzBuzzAlgo() {
        Integer int1 = 3;
        Integer int2 = 5;
        Integer limit = 15;
        String str1 = "fizz";
        String str2 = "buzz";
        FizzBuzzRequest fizzBuzzRequest = new FizzBuzzRequest(3, 5, 15, "fizz", "buzz");
        List<String> expectedList = List.of("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz");
        when(fizzBuzzService.getEncryptedResultUsingFizzBuzzAlgorithm(fizzBuzzRequest)).thenReturn(expectedList);
        ResponseEntity<FizzBuzzResponse> responseEntity = fizzBuzzController.getFizzBuzzAlgo(int1, int2, limit, str1, str2);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Success", responseEntity.getBody().getMessage());
        assertEquals(expectedList, responseEntity.getBody().getData());
    }

    @Test
    void getStatistics() {
        Map<String, Object> expectedResult = Map.ofEntries(
                Map.entry("most used request", new FizzBuzzRequest(3, 5, 15, "fizz", "buzz")),
                Map.entry("most frequent request", 10)
        );
        when(fizzBuzzService.getStatistics()).thenReturn(expectedResult);
        ResponseEntity<FizzBuzzResponse> responseEntity = fizzBuzzController.getStatistics();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Success", responseEntity.getBody().getMessage());
        assertEquals(expectedResult, responseEntity.getBody().getData());
    }
}