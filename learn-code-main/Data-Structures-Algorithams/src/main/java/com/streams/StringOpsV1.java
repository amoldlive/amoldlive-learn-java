package com.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StringOpsV1 {
    public static void main(String[] args) {
        String input = "Java articles are Awesome";

        //convert to uppercase
        input.codePoints().mapToObj(i->((char)i)+"".toUpperCase() ).toList().forEach(System.out::println);

        System.out.println();

        //find the first non-repeated character
      char result=  input.chars()
                .mapToObj(i->Character.toLowerCase((char)i))
                .collect( Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry->entry.getValue()==1L)
                .map(entry->entry.getKey())
                .findFirst()
                .get();
      System.out.println(result);

        System.out.println();
        //get the duplicate element
        List<String> names=  Arrays.asList("AA", "BB", "AA", "CC","CC");
        names.stream().filter(name-> Collections.frequency(names,name)>1L)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
