package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Service class to handle number generation and analysis.
 */
@Service
public class NumberService {

    // Explicitly private and final for clarity.
    private final Random random = new Random();

    /**
     * Generates an array of the given size with random integers in [0, maxInclusive].
     */
    public int[] generateRandomArray(int size, int maxInclusive) {
        // If deterministic tests or security needs arise, consider injecting a different Random or SecureRandom.
        return random.ints(size, 0, maxInclusive + 1).toArray();
    }

    /**
     * Given three arrays and a max inclusive value, returns all integers in [0, maxInclusive]
     * that are NOT present in any of the arrays.
     *
     * For very large maxInclusive, consider a more memory-efficient approach than building a full set.
     */
    public List<Integer> getAvailableNumbers(int[] arr1, int[] arr2, int[] arr3, int maxInclusive) {
        Set<Integer> allNumbers = IntStream.rangeClosed(0, maxInclusive).boxed().collect(Collectors.toSet());

        // Inline the previously separate addArrayToSet logic
        Set<Integer> usedNumbers = new HashSet<>();
        for (int num : arr1) {
            usedNumbers.add(num);
        }
        for (int num : arr2) {
            usedNumbers.add(num);
        }
        for (int num : arr3) {
            usedNumbers.add(num);
        }

        allNumbers.removeAll(usedNumbers);
        return new ArrayList<>(allNumbers);
    }

    /**
     * Finds the largest prime number in the given list or returns null if none exist.
     */
    public Integer getLargestPrime(List<Integer> numbers) {
        return numbers.stream()
                .filter(NumberService::isPrime)
                .max(Integer::compareTo)
                .orElse(null);
    }

    /**
     * Checks if a number is prime.
     * For the given problem constraints (0–50), this approach is sufficient.
     */
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        int limit = (int)Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
