package com.java.eight;

import java.util.stream.IntStream;

/*Write a program to find the sum of a given array of int in java8.*/
public class FindSumOfArrayElements {
	public static void main(String[] args) {
		
		int[] arr= {10,20,30,40,50};
		int sum=IntStream.of(arr).sum();
		System.out.println("Sum : "+sum);
		sum=IntStream.of(arr).filter(val->val%2!=0).sum();
		System.out.println("Sum : "+sum);
	}
}
