package com.java8;

import java.util.List;
import java.util.stream.Collectors;

public class streamExample2 {
	public static void main(String[] args) {

	List<Character> list=List.of('a','b','c','d','e');
	list.stream().map(val-> "Hello "+val).collect(Collectors.toList()).forEach(System.out::println);
		
		
	}
}
