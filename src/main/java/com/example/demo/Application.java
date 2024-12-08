package com.example.demo;

import com.example.demo.service.NumberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	private static final int ARRAY_SIZE = 15;
	private static final int MAX_INCLUSIVE = 50;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		NumberService numberService = ctx.getBean(NumberService.class);

		int[] arr1 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);
		int[] arr2 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);
		int[] arr3 = numberService.generateRandomArray(ARRAY_SIZE, MAX_INCLUSIVE);

		List<Integer> availableNumbers = numberService.getAvailableNumbers(arr1, arr2, arr3, MAX_INCLUSIVE);
		Integer largestPrime = numberService.getLargestPrime(availableNumbers);

		System.out.println("=== Results ===");
		System.out.println("Array 1: " + Arrays.toString(arr1));
		System.out.println("Array 2: " + Arrays.toString(arr2));
		System.out.println("Array 3: " + Arrays.toString(arr3));
		System.out.println("Available Numbers: " + availableNumbers);
		System.out.println("Largest Prime: " + (largestPrime != null ? largestPrime : "None"));
	}
}
