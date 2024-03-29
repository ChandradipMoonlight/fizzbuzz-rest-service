package com.moonlight.fizzbuzz.service;

import com.moonlight.fizzbuzz.dao.FizzBuzzDaoService;
import com.moonlight.fizzbuzz.dto.FizzBuzzRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{
    @Autowired
    private FizzBuzzDaoService fizzBuzzDaoService;
    @Override
    public List<String> getEncryptedResultUsingFizzBuzzAlgorithm(FizzBuzzRequest fizzBuzzRequest) {
        fizzBuzzDaoService.updateFrequencyOfFizzBuzzRequest(fizzBuzzRequest);
        return IntStream.rangeClosed(1, fizzBuzzRequest.getLimit())
                .boxed()
                .map(number -> convertToString(number, fizzBuzzRequest))
                .collect(Collectors.toList());
    }


    public Map<String, Object> getStatistics() {
        return fizzBuzzDaoService.getFrequencyOfFizzBuzzRequest()
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> Map.of("most used request", entry.getKey(), "most frequent request", entry.getValue()))
                .orElse(null);
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
