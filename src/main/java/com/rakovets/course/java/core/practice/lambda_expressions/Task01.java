package com.rakovets.course.java.core.practice.lambda_expressions;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task01 {
    public Map<String, String> convertArrayToMap(String[] inputArray) {
        return Stream.iterate(0, x -> x < inputArray.length, x -> x + 2).collect(Collectors
                .toMap(x -> inputArray[x], x -> inputArray[x + 1]));
    }

    public String[] convertMapToArray(Map<String, String> map) {
        return map.entrySet().stream().flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                .toArray(String[]::new);
    }
}
