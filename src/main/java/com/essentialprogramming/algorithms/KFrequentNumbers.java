package com.essentialprogramming.algorithms;

// Find k elements with max occurrence.

import java.util.*;
import java.util.stream.Collectors;

public class KFrequentNumbers {

    static void print_K_mostFrequentNumberV1(int[] arr, int k) {

        //Create a HashMap to store element-frequency pair.
        final Map<Integer, Long> frequencyMap = new HashMap<>();

        for (int element : arr) {
            //frequencyMap.put(element, frequencyMap.getOrDefault(element, 0L) + 1);
            frequencyMap.putIfAbsent(element, 1L);
            frequencyMap.computeIfPresent(element, (key, val) -> {
                val = val + 1;
                return val;
            });
        }


        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list
        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return b.getKey() - a.getKey();
            else
                return (int) (b.getValue() - a.getValue());
        });

        for (int i = 0; i < k; i++)
            System.out.print(list.get(i).getKey() + " ");
        System.out.println();
    }

    static void print_K_mostFrequentNumberV2(int[] arr, int k) {

        //Create a HashMap to store element-frequency pair.
        final Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(), a.getKey())
                        : Long.compare(b.getValue(), a.getValue()));

        // Insert the data from the map to the Priority Queue.
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet())
            queue.offer(entry);

        for (int i = 0; i < k; i++)
            System.out.print(Objects.requireNonNull(queue.poll()).getKey() + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 3, 5, 5, 5, 2, 6, 1};
        int k = 3;

        // Function call
        print_K_mostFrequentNumberV1(arr, k);
        print_K_mostFrequentNumberV2(arr, k);
    }
}
