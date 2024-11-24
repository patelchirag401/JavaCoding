package com.bitwise;

public class MultiplyBy7 {
	public static void main(String[] args) {
		System.out.println(multiplyBy7(8));
	}

	private static int multiplyBy7(int number) {
// multiply by 8 using bitwise left shift operator (2^3 = 8)
		int result = number >> 3;
		result = result - number;
		return result;
	}
}