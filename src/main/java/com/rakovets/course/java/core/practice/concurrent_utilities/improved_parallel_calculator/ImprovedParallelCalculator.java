package com.rakovets.course.java.core.practice.concurrent_utilities.improved_parallel_calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ImprovedParallelCalculator {
    private static final Logger logger = Logger.getLogger(ImprovedParallelCalculator.class.getName());
    private final ReentrantLock locker = new ReentrantLock();

    public List<Pair> getListOfArray(List<int[]> arrays) {
        List<Pair> pairs = new ArrayList<>();
        for (int[] array : arrays) {
            pairs.add(new Pair(array, Arrays.stream(array).sum()));
        }
        return pairs;
    }

    public List<Pair> convertListOfArrayToSumOfElements(List<int[]> arrays, int countOfThread) {
        List<Pair> pairs = Collections.synchronizedList(new ArrayList<>());
        long startTime = System.currentTimeMillis();
        try {
            locker.lock();
            ExecutorService poolThread = Executors.newFixedThreadPool(countOfThread);

            for (int[] array : arrays) {
                poolThread.execute(() -> {
                    pairs.add(new Pair(array, Arrays.stream(array).sum()));
                    logger.info("Thread " + Thread.currentThread().getName() + " add pair");
                });
            }

            poolThread.shutdown();
            while (!poolThread.isTerminated()) {
                logger.info("Need to wait until the thread's end");
            }
            logger.info("Thread " + countOfThread + " ends with milliseconds: " + (System.currentTimeMillis() - startTime));
        } finally {
            locker.unlock();
        }
        return pairs;
    }

    public void printPairs(List<Pair> pairs) {
        for (Pair pair : pairs) {
            System.out.println(pair.toString());
        }
    }
}
