package com.streams;

import java.util.*;

public class NumberOpsV1 {
    public static void main(String[] args) {
        //find number starting with 1
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream().map(num->num.toString()).filter(num->num.startsWith("1")).forEach(System.out::println);

        System.out.println();

        //find duplicate elements
        myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> data=new HashSet<>();
        myList.stream().filter(num->!data.add(num)).forEach(System.out::println);

        System.out.println();

        //find first element
        myList=Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().findFirst().ifPresent(System.out::println);

        System.out.println();

        //find total element
        myList=Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList.stream().count());

        //find max number
        System.out.println();
        myList=Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList.stream().max(Integer::compare).get());
        System.out.println(myList.stream().min(Integer::compare).get());

        System.out.println();

        //sort the list - asscending
        myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().sorted().forEach(System.out::println);

        System.out.println();

        //sort the list - asscending
        myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


        System.out.println();

        //check if list contains duplicate
        myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set=new HashSet<>(myList);
        System.out.println("IS duplaicated - "+(set.size()==myList.size()));



        System.out.println();


        System.out.println();

    }
}
