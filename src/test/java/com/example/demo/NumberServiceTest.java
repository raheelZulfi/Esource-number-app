package com.example.demo;

import com.example.demo.service.NumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberServiceTest {

	private NumberService service;

	@BeforeEach
	void setUp() {
		service = new NumberService();
	}

	@Test
	void testGetAvailableNumbers_example() {
		int[] arr1 = {3, 4, 5, 6, 7};
		int[] arr2 = {1, 4, 5, 6, 10};
		int[] arr3 = {0, 1, 2, 3, 5};
		List<Integer> available = service.getAvailableNumbers(arr1, arr2, arr3, 10);
		// Expected [8, 9]
		assertEquals(List.of(8, 9), available);
	}

	@Test
	void testGetAvailableNumbers_edgeCase() {
		// Edge case: maxInclusive = 0, meaning only one possible number: 0
		int[] arr1 = {};
		int[] arr2 = {};
		int[] arr3 = {};
		List<Integer> available = service.getAvailableNumbers(arr1, arr2, arr3, 0);
		// Since no arrays have numbers, 0 is available
		assertEquals(List.of(0), available);
	}

	@Test
	void testGetLargestPrime_multiplePrimes() {
		List<Integer> numbers = List.of(8, 9, 11, 13, 4, 2);
		// Multiple primes (2, 11, 13), largest is 13
		assertEquals(13, service.getLargestPrime(numbers));
	}

	@Test
	void testGetLargestPrime_singlePrime() {
		List<Integer> numbers = List.of(4, 6, 10, 3);
		// Only one prime (3)
		assertEquals(3, service.getLargestPrime(numbers));
	}

	@Test
	void testGetLargestPrime_allPrimes() {
		List<Integer> numbers = List.of(2, 3, 5, 7);
		// All are primes, largest is 7
		assertEquals(7, service.getLargestPrime(numbers));
	}

	@Test
	void testGetLargestPrime_noPrimes() {
		List<Integer> numbers = List.of(0, 1, 4, 8, 9);
		// No prime numbers
		assertNull(service.getLargestPrime(numbers));
	}

	@Test
	void testGetLargestPrime_withNegatives() {
		// Includes negative numbers and a non-prime positive number
		List<Integer> numbers = List.of(-3, -1, 15, 16);
		// None are prime
		assertNull(service.getLargestPrime(numbers));
	}
}
