package com.javatest.test.algorithms.array;

import com.javatest.algorithms.array.MaxSubArray;
import static com.javatest.algorithms.array.MaxSubArray.SubArray;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test cases for {@link MaxSubArray Maximum Sub Array Linear Time Algorithm}
 */
public class MaxSubArrayTest {
	/**
	 * Test MaxSubArray for all positive numbers.
	 */
	@Test
	public void testWithAllPositive() {
		int[] inputArray = {12, 41, 23, 11, 4, 21};
		SubArray expected = new SubArray(0, 5, 112);
		SubArray result = MaxSubArray.getMaxSubArray(inputArray);
		assertEquals("Expected: {" + expected + "} vs Actual Result: {" + result + "}" , expected, result);
	}

	/**
	 * Test with all negative integers so that the negative integer close to zero is chosen as the maximum subarray.
	 */
	@Test
	public void testWithAllNegative() {
		int[] inputArray = {-12, -41, -23, -11, -4, -21};
		SubArray expected = new SubArray(4, 4, -4);
		SubArray result = MaxSubArray.getMaxSubArray(inputArray);
		assertEquals("Expected: {" + expected + "} vs Actual Result: {" + result + "}" , expected, result);
	}

	/**
	 * Test with all negative but one zero, so that the maximum array consists only of the zero.
	 */
	@Test
	public void testWithMaxZero() {
		int[] inputArray = {-12, -41, 0, -23, -11, -4, -21};
		SubArray expected = new SubArray(2, 2, 0);
		SubArray result = MaxSubArray.getMaxSubArray(inputArray);
		assertEquals("Expected: {" + expected + "} vs Actual Result: {" + result + "}" , expected, result);
	}

	/**
	 * Test with mixed values so that the maximum array could contain both positive and negative elements.
	 */
	@Test
	public void testWithMixedValues() {
		int[] inputArray = {5, -1, 4, 3, -2, 0, -1, 6, -1};
		SubArray expected = new SubArray(0, 7, 14);
		SubArray result = MaxSubArray.getMaxSubArray(inputArray);
		assertEquals("Expected: {" + expected + "} vs Actual Result: {" + result + "}" , expected, result);
	}
}
