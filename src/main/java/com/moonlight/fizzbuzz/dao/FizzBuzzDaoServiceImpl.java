package com.moonlight.fizzbuzz.dao;

import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FizzBuzzDaoServiceImpl implements FizzBuzzDaoService{
    private final Map<FizzBuzzRequest, Integer> fizzBuzzRequestFrequency = new HashMap<>();


    @Override
    public void updateFrequencyOfFizzBuzzRequest(FizzBuzzRequest fizzBuzzRequest) {
        fizzBuzzRequestFrequency.put(fizzBuzzRequest, fizzBuzzRequestFrequency.getOrDefault(fizzBuzzRequest, 0)+1);
    }

    @Override
    public Map<FizzBuzzRequest, Integer> getFrequencyOfFizzBuzzRequest() {
        return this.fizzBuzzRequestFrequency;
    }

}
