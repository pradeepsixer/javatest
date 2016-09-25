package com.javatest.test.algorithms.sort;

import com.javatest.algorithms.sort.MergeSort;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Testing the {@link MergeSort Merge Sort} implementation
 * @author Pradeep Kumar
 */
public class MergeSortTest {
	/**
	 * Test case for merge sort.
	 */
	 @Test
	public void testMergeSort() {
		Integer[] input = {5646, 6543, 151, 874, 6157, 9654, 24, 86, 954, 67, 3514};
		Integer[] output = MergeSort.sort(input);
		Integer[] expected = {24, 67, 86, 151, 874, 954, 3514, 5646, 6157, 6543, 9654};
		assertArrayEquals(output, expected);
	}
}
