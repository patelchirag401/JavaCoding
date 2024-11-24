package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenArray {
    public static List<Object> flatten(Object[] arr, int depth) {
        Queue<Object> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(arr));

        while (depth > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object item = queue.poll();
                if (item instanceof List<?>) {
                    List<Object> subArray = new ArrayList<Object>((List<?>) item);
                    queue.addAll(subArray);
                } else {
                    queue.add(item);
                }
            }
            depth--;
        }

        return new ArrayList<Object>(queue);
    }

    public static void main(String[] args) {
        Object[] arr = new Object[]{
            1, 2, 3,
            Arrays.asList(4, 5, 6),
            Arrays.asList(
                7, 8,
                Arrays.asList(9, 10, 11),
                12
            ),
            Arrays.asList(13, 14, 15)
        };

        List<Object> flattened = flatten(arr, 1);
        System.out.println(flattened);
    }
}