package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WithRecursive {
	 public static List<Integer> flatten(List<Object> input, int level) {
	        List<Integer> result = new ArrayList<>();

	        for (Object element : input) {
	            if (element instanceof Integer) {
	                result.add((Integer) element);
	            } else if (element instanceof List) {
	                result.addAll(flatten((List<Object>) element, level + 1));
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        List<Object> nestedArray = Arrays.asList(1, 2, Arrays.asList(3, 4, Arrays.asList(5, 6)), 7, 8);

	        List<Integer> flattenedArray = flatten(nestedArray, 0);

	        System.out.println("Original Nested Array: " + nestedArray);
	        System.out.println("Flattened Array: " + flattenedArray);
	    }
	}