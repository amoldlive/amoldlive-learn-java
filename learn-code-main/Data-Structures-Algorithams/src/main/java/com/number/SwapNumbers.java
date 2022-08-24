package com.number;

public class SwapNumbers {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println("a : " + a + "    b : " + b);
		b=a+b;
		a=b-a;
		b=b-a;
		
		System.out.println("a : " + a + "    b : " + b);
	}
}
