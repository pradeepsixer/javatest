package com.javatest.algorithms.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	public T[] sort(T[] input) {
		if (input.length == 1) {
			return input;
		} else {
			@SuppressWarnings("unchecked")
			T[] output = (T[]) Array.newInstance(input.getClass().getComponentType(), input.length);
			int halfLength = (int) (Math.ceil(input.length / 2));

			T[] firstHalf = sort(Arrays.copyOfRange(input, 0, halfLength));
			T[] secondHalf = sort(Arrays.copyOfRange(input, halfLength, input.length));

			int firstPtr = 0, secondPtr = 0;

			for (int i=0; i<input.length; i++) {
				if (firstPtr == firstHalf.length) {
					output[i] = secondHalf[secondPtr++];
				} else if (secondPtr == secondHalf.length) {
					output[i] = firstHalf[firstPtr++];
				} else {
					if (firstHalf[firstPtr].compareTo(secondHalf[secondPtr]) <= 0) {
						output[i] = firstHalf[firstPtr++];
					} else {
						output[i] = secondHalf[secondPtr++];
					}
				}
			}
			return output;
		}
	}
}
