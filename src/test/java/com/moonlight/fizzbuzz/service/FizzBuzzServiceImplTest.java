package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dao.FizzBuzzDaoService;
import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
class FizzBuzzServiceImplTest {

    @Mock
    private FizzBuzzDaoService fizzBuzzDaoService;

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEncryptedResultUsingFizzBuzzAlgorithm() {
        FizzBuzzRequest fizzBuzzRequest = new FizzBuzzRequest(3, 5, 15, "fizz", "buzz");

        // Mock the behavior of the fizzBuzzDaoService
        doNothing().when(fizzBuzzDaoService).updateFrequencyOfFizzBuzzRequest(fizzBuzzRequest);

        // Invoke the service method
        List<String> result = fizzBuzzService.getEncryptedResultUsingFizzBuzzAlgorithm(fizzBuzzRequest);
        System.out.println(result);
        // Verify that the dao service method was called
        verify(fizzBuzzDaoService, times(1)).updateFrequencyOfFizzBuzzRequest(fizzBuzzRequest);

        List<String> expectedList = List.of("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz");
        assertEquals(expectedList, result);
    }

    @Test
    void getStatistics() {
        // Mock the behavior of the fizzBuzzDaoService
        when(fizzBuzzDaoService.getFrequencyOfFizzBuzzRequest()).thenReturn(getMockedFrequencyMap());

        // Invoke the service method
        Map<String, Object> actualResult = fizzBuzzService.getStatistics();

        // Verify that the dao service method was called
        verify(fizzBuzzDaoService, times(1)).getFrequencyOfFizzBuzzRequest();

        // You can further assert the content of the result map based on your logic
        Map<String, Object> expectedResult = Map.ofEntries(
                Map.entry("most used request", new FizzBuzzRequest(3, 5, 15, "fizz", "buzz")),
                Map.entry("most frequent request", 10)
        );
        assertEquals(expectedResult, actualResult);
    }
    private Map<FizzBuzzRequest, Integer> getMockedFrequencyMap() {
        // Provide a sample mocked frequency map for testing
        Map<FizzBuzzRequest, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(new FizzBuzzRequest(3, 5, 15, "fizz", "buzz"), 10);
        frequencyMap.put(new FizzBuzzRequest(3, 2, 10, "fizz", "buzz"), 5);
        return frequencyMap;
    }
}