package com.example.demo;

import com.example.demo.service.NumberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

	private static final int ARRAY_SIZE = 15;
	private static final int MAX_INCLUSIVE = 50;

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Application.class, args);

		NumberService numberService = ctx.getBean(NumberService.class);

		// Generate the three random arrays
		int[] arr1 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);
		int[] arr2 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);
		int[] arr3 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);

		// Compute available numbers
		List<Integer> availableNumbers = numberService.getAvailableNumbers(arr1, arr2, arr3, MAX_INCLUSIVE);

		// Find the largest prime among the available numbers
		Integer largestPrime = numberService.getLargestPrime(availableNumbers);

		// Print results
		System.out.println("=== Results ===");
		System.out.println("Array 1: " + arrayToString(arr1));
		System.out.println("Array 2: " + arrayToString(arr2));
		System.out.println("Array 3: " + arrayToString(arr3));
		System.out.println("Available Numbers: " + availableNumbers);
		System.out.println("Largest Prime: " + (largestPrime != null ? largestPrime : "None"));
	}

	private static String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
