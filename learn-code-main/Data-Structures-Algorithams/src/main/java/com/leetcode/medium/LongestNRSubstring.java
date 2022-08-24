package com.leetcode.medium;

import java.util.HashSet;

/*
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "pwwkew", the answer is "wke", with the length of 3.
*/
public class LongestNRSubstring {
	public static void main(String[] args) {
		String input = "abcabcbb";

		findSubstringAndLength(input);
	}

	public static void findSubstringAndLength(String input) {
		HashSet<Character> set = new HashSet();

		int j = 0;
		int i = 0;
		for (i = 0; i < input.length(); i++) {

			while (set.contains(input.charAt(i))) {

				set.remove(input.charAt(j++));
			}

			set.add(input.charAt(i));

		}

	}
}
