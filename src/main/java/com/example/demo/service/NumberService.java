package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Service class to handle number generation and analysis.
 * Responsibilities:
 * - Generate random arrays of integers.
 * - Compute available numbers not present in given arrays.
 * - Find the largest prime in a list of integers.
 */
@Service
public class NumberService {

    private final Random random = new Random();

    /**
     * Generates an array of the given size with random integers in [0, maxInclusive].
     * @param size the size of the array
     * @param maxInclusive the maximum random number (inclusive)
     * @return an array of random integers
     */
    public int[] generateRandomArray(int size, int maxInclusive) {
        return random.ints(size, 0, maxInclusive + 1).toArray();
    }

    /**
     * Given three arrays and a max inclusive value, returns all integers in [0, maxInclusive]
     * that do not appear in ANY of the arrays.
     * @param arr1 first array
     * @param arr2 second array
     * @param arr3 third array
     * @param maxInclusive upper bound of numbers range
     * @return a list of available (unused) numbers
     */
    public List<Integer> getAvailableNumbers(int[] arr1, int[] arr2, int[] arr3, int maxInclusive) {
        Set<Integer> allNumbers = IntStream.rangeClosed(0, maxInclusive).boxed().collect(Collectors.toSet());

        Set<Integer> usedNumbers = new HashSet<>();
        addArrayToSet(usedNumbers, arr1);
        addArrayToSet(usedNumbers, arr2);
        addArrayToSet(usedNumbers, arr3);

        allNumbers.removeAll(usedNumbers);
        return new ArrayList<>(allNumbers);
    }

    /**
     * Finds the largest prime number in a given list.
     * If none are prime, returns null.
     * @param numbers list of integers
     * @return the largest prime or null if none
     */
    public Integer getLargestPrime(List<Integer> numbers) {
        return numbers.stream()
                .filter(NumberService::isPrime)
                .max(Integer::compareTo)
                .orElse(null);
    }

    private void addArrayToSet(Set<Integer> set, int[] array) {
        for (int num : array) {
            set.add(num);
        }
    }

    /**
     * Determines if a given number is prime.
     * @param num the number to check
     * @return true if prime, false otherwise
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
