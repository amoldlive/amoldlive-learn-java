package com.string;

/*
Given a list of words, find the minimum distance between two words.
Eg given 
{ the brown fox jumps over the fence jumps brown fox} 
and the words brown &
Jumps. 
The minimum value returned should be 0
For, fox & the (1, 3, 2) -> 1
*/
public class MinDistanceBetweenTwoWords {
	public static void main(String[] args) {
		String statement = "the brown fox jumps over the fence jumps brown fox";
		String arr[] = statement.split(" ");

		String word1 = "brown";
		String word2 = "brown";

		int index1 = -1;
		int index2 = -1;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i].equals(word1))
				index1 = i;

			if (arr[i].equals(word2))
				index2 = i;

			if(index1!=-1 && index2!=-1)
				min=Math.min(min,Math.abs(index1-index2));
		}
		System.out.println("mininum Distance : "+min+"			 "+index1+"		"+index2);

	}
}
