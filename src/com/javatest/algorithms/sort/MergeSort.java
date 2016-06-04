package com.javatest.algorithms.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Merge Sort algorithm implementation
 * 
 * @author Pradeep Kumar
 *
 * @param <T> The Data Type of the elements to be sorted. Such data type must implement the {@link Comparable} interface
 */
public class MergeSort<T extends Comparable<T>> {

	/**
	 * Recursively sort the input elements.
	 * @param input The input array containing the elements to be sorted.
	 * @return Array containing the sorted elements.
	 */
	public T[] sort(T[] input) {
		/*
		 * Algorithm:
		 * 1. If the number of elements is 1, then it is already sorted. just return the input
		 * 2. If the number of elements is greater than 1, then split the input array into 2.
		 * 3. Recursively split these two arrays.
		 * 4. At a point, the number of input will be 1 for both the split array. This is where the
		 * 		sorting begins within recursion
		 * 5. While merging (and sorting) the split arrays, we compare the head of each array.
		 * 6. Place the smaller element of either array into the output array and move the head pointer
		 * 		of the array X to the next element, if available.
		 * 7. Repeat this until the elements in both the arrays are exhausted. Now the output array
		 * 		will contain the elements of both the input arrays in a sorted manner.
		 */
		if (input.length == 1) {
			return input;
		} else {
			@SuppressWarnings("unchecked")
			T[] output = (T[]) Array.newInstance(input.getClass().getComponentType(), input.length);
			int halfLength = (int) (Math.ceil(input.length / 2));

			T[] firstHalf = sort(Arrays.copyOfRange(input, 0, halfLength));
			T[] secondHalf = sort(Arrays.copyOfRange(input, halfLength, input.length));

			// The pointers for the first and second array. Used for comparison of elements.
			int firstPtr = 0, secondPtr = 0;

			/*
			 * Repeat this until the size of the input:
			 * 1. If the firstPtr has reached the size of firstHalf, it means that all the elements of
			 * 		the first array has been placed into the output array, so now place the elements of
			 * 		the second array into the output.
			 * 2. Likewise, for secondPtr.
			 * 3. If both the above conditions fail, then compare the elements in both the array and place
			 * 		it in the output array accordingly. 
			 */
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

