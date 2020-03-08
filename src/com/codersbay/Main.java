package com.codersbay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unsorted = Arrays.asList(5, 4, 9, 1, 6, 7, 3, 2, 8, 12, 17, 11, 26, 21);
        List<Integer> sorted = new ArrayList<>();
        System.out.println("\nUnsorted => " + unsorted);
        System.out.println("\n  Sorted => " + mergeSort(unsorted, sorted, 0));
    }

    private static List<Integer> mergeSort(List<Integer> inputArray, List<Integer> merge, int depth) {
        if (inputArray.size() > 2) {
            List<Integer> first = inputArray.subList(0, inputArray.size() / 2);
            List<Integer> second = inputArray.subList(inputArray.size() / 2, inputArray.size());
            depth++;
            List<Integer> left = mergeSort(first, merge, depth);
            List<Integer> right = mergeSort(second, merge, depth);
            merge = tempSort(left, right);
            return merge;
        } else if (inputArray.size() == 2) {
            if (inputArray.get(0) > inputArray.get(1)) {
                int temp = inputArray.get(0);
                inputArray.set(0, inputArray.get(1));
                inputArray.set(1, temp);
            }
            // System.out.println("\t\t\t\t       "+inputArray.toString());
            // System.out.println("\t\t\t\tsorted "+"*".repeat(8));
            return inputArray;
        } else if (inputArray.size() == 1) {
            // System.out.println("\t\t\t\t       "+inputArray.toString());
            // System.out.println("\t\t\t\tsorted "+"*".repeat(8));
            return inputArray;
        } else {
            throw new IllegalArgumentException("this is not a legal Argument");
        }
    }

    private static List<Integer> tempSort(List<Integer> tempLeft, List<Integer> tempRight) {
        List<Integer> tempUnSorted = new ArrayList<>(tempLeft);
        tempUnSorted.addAll(tempRight);

        List<Integer> tempSorted = new ArrayList<>();
        int targetSizeOfTempSorted = tempLeft.size() + tempRight.size();
        int start = 0;
        int temp;
        int pointer = 0;
        while (tempSorted.size() < targetSizeOfTempSorted) {
            temp = tempUnSorted.get(start);
            for (int i = start; i < tempUnSorted.size(); i++) {
                if (tempUnSorted.get(i) < temp) {
                    temp = tempUnSorted.get(i);
                    pointer = i;
                }
            }
            tempUnSorted.set(pointer, tempUnSorted.get(start));
            tempSorted.add(temp);
            start++;
        }
        return tempSorted;
    }
}
