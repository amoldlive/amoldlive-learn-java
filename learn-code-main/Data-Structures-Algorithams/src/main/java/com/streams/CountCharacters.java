package com.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {
    public static void main(String[] args) {

        String input="i am amol dhawale worked in globant india";
        Map<String,Long> countMap=input.codePoints().mapToObj(Character::toString).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(countMap);

       List<String> inputList= input.chars().mapToObj(Character::toString).toList();
        System.out.println(inputList);

    }
}
