package com.rakovets.course.java.core.practice.lambda_expressions;

import java.util.stream.IntStream;

public class Task02 {
    public void printMultiplicationTableFrom1to10In1column() {
        IntStream.range(1, 11).forEach((x) -> {
            IntStream.range(1, 11).forEach((y) ->
                    System.out.printf("%d * %d = %d\n", y, x, y * x));
            System.out.println();
        });
    }

    public void printMultiplicationTableFrom1to10In5columns() {
        IntStream.range(1, 11).forEach((x) -> {
            IntStream.range(1, 6).forEach((y) -> System.out.printf("%d * %d = %d\t", y, x, y * x));
            System.out.println();
        });
        System.out.println();
        IntStream.range(1, 11).forEach((x) -> {
            IntStream.range(6, 11).forEach((y) -> System.out.printf("%d * %d = %d\t", y, x, y * x));
            System.out.println();
        });
    }
}
