package com.java8;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {

		List<String> list = List.of("A", "B", "A", "C", "Z", "D", "V", "B");

		// filter A & B
		list.stream().filter(val -> val.equals("A") || val.equals("B")).collect(Collectors.toList())
				.forEach(System.out::println);

		String statement = "orange mango kiwi orange apple kiwi orange kiwi apple watermelon orange";
		
		TreeMap<String, Integer> map=new TreeMap();
		
		for (String word : statement.split(" ")) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		map.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList()).forEach(e1->System.out.println(e1.getKey()+" "+e1.getValue()));;
	}
}
