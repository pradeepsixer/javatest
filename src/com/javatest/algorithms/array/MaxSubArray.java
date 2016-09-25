package com.javatest.algorithms.array;

import java.util.ArrayList;

/**
 * This is a solution for the maximum subarray problem in linear time. Since this was aimed for small case of numbers, the total sum
 * cannot exceed {@link Long#MAX_VALUE Long's Maximum Value}.
 * @author Pradeep Kumar
 */
public class MaxSubArray {
	/**
	 * This class contains the details of the SubArray like starting index of the subarray, ending index of the subarray and sum of the subarray. 
	 */
	public static class SubArray implements Comparable<SubArray> {
		private int startIndex;
		private int endIndex;
		
		// If larger values are needed, then {@link java.math.BigInteger BigInteger} can be used
		private long sum;

		/**
		 * Default Constructor.
		 */
		public SubArray() {
			this.setValues(-1, -1, Long.MIN_VALUE);
		}

		/**
		 * Constructor - Initialize the subarray with custom Start Index, End Index and Sum
		 * @param startIndex The Starting Index of the subarray
		 * @param endIndex The Ending Index of the subarray
		 * @param sum The sum of the subarray
		 */
		public SubArray(int startIndex, int endIndex, long sum) {
			this.setValues(startIndex, endIndex, sum);
		}

		/**
		 * Sets the custom values (start index, end index and sum) for the subarray
		 * @param startIndex The starting index of the subarray
		 * @param endIndex The ending index of the subarray
		 * @param sum The sum of the subarray
		 */
		public void setValues(int startIndex, int endIndex, long sum) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.sum = sum;
		}

		/**
		 * Copy the values from another SubArray object
		 * @param sourceObj The source SubArray object from which the values are to be copied
		 */
		public void copy(SubArray sourceObj) {
			this.setValues(sourceObj.startIndex, sourceObj.endIndex, sourceObj.sum);
		}

		@Override
		public int compareTo(SubArray obj) {
			if (sum > obj.sum) {
				return 1;
			} else if (sum < obj.sum) {
				return -1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null) {
				if (obj instanceof SubArray) {
					SubArray convObj = (SubArray) obj;
					if (this.sum == convObj.sum && this.startIndex == convObj.startIndex && this.endIndex == convObj.endIndex) {
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public int hashCode() {
			int hashCode = 1;
			hashCode = 31*hashCode + startIndex;
			hashCode = 31*hashCode + endIndex;
			hashCode = 31*hashCode + (int)(sum ^ (sum >>> 32));
			return hashCode;
		}

		@Override
		public String toString() {
			return "[start - \"" + startIndex + "\", end - \"" + endIndex + "\", sum - \"" + sum +"\"]";
		}
	}

	/**
	 * Get the contiguous maximum subarray for the given input array
	 * @param inputArray The input array for which the maximum subarray is to be found
	 */
	public static SubArray getMaxSubArray(int[] inputArray) {
		/*
		 * 1. Start with the first element, iterate through the array, storing the sum so far.
		 * 2. If the sum at any point gets below zero, reset the subarray to the next array element.
		 * 3. In each iteration, compare the sum to the maximum sum encountered so far and update it.
		 */

		long sum = inputArray[0];
		SubArray currSubArray = new SubArray(0, 0, sum), maxSubArray = new SubArray(0, 0, sum);
		for(int i=1; i<inputArray.length; i++) {
			if (sum < 0) {
				sum = inputArray[i];
				currSubArray.setValues(i, i, inputArray[i]);
			} else {
				sum += inputArray[i];
				currSubArray.setValues(currSubArray.startIndex, i, sum);
			}
			if (maxSubArray.compareTo(currSubArray) < 0) {
				maxSubArray.copy(currSubArray);
			}
		}
		return maxSubArray;
	}
}
