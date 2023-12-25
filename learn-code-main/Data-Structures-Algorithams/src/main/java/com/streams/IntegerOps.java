package com.streams;

import java.util.Arrays;

public class IntegerOps {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,8};
        Arrays.stream(nums).boxed().toList().forEach(System.out::println);

        Long count=Arrays.stream(nums).boxed().count();
        System.out.println(count);

        int sum=Arrays.stream(nums).boxed().mapToInt(i->i).sum();
        System.out.println(sum);

         Arrays.stream(nums).boxed().map(i->i*2).toList().forEach(System.out::println);

    }
}
