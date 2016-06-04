package com.javatest.test.algorithms.sort;

import com.javatest.algorithms.sort.MergeSort;

public class MergeSortTest {
	public static void main(String[] args) {
		MergeSort<Integer> mergeSortInt = new MergeSort<Integer>();
		Integer[] input = {5646, 6543, 151, 874, 6157, 9654, 24, 86, 954, 67, 3514};
		Integer[] output = mergeSortInt.sort(input);
		for (Integer eachNum : output) {
			System.out.println(eachNum);
		}
	}
}
