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
		// Example from the requirements
		int[] arr1 = {3, 4, 5, 6, 7};
		int[] arr2 = {1, 4, 5, 6, 10};
		int[] arr3 = {0, 1, 2, 3, 5};
		List<Integer> available = service.getAvailableNumbers(arr1, arr2, arr3, 10);
		assertEquals(List.of(8, 9), available, "Available numbers should be [8, 9]");
	}

	@Test
	void testGetLargestPrime() {
		List<Integer> numbers = List.of(8, 9, 11, 13, 4, 2);
		assertEquals(13, service.getLargestPrime(numbers), "Largest prime should be 13");
	}

	@Test
	void testGetLargestPrime_noPrimes() {
		List<Integer> numbers = List.of(0, 1, 4, 8, 9);
		assertNull(service.getLargestPrime(numbers), "No primes should return null");
	}
}
