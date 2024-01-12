package com.moonlight.fizzbuzz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzzRequest {
    private Integer int1;
    private Integer int2;
    private Integer limit;
    private String str1;
    private String str2;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof FizzBuzzRequest that)) return false;
        return Objects.equals(getInt1(), that.getInt1()) &&
                Objects.equals(getInt2(), that.getInt2()) &&
                Objects.equals(getLimit(), that.getLimit()) &&
                Objects.equals(getStr1(), that.getStr1()) &&
                Objects.equals(getStr2(), that.getStr2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInt1(), getInt2(), getLimit(), getStr1(), getStr2());
    }
}
