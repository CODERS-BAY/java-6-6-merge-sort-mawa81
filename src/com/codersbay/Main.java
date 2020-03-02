package com.codersbay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unsorted = Arrays.asList(5, 4, 1, 9, 6, 7, 3, 2, 8);

        System.out.println("Sorted => " + divideAndSort(unsorted, 0));
    }

    private static List<Integer> divideAndSort(List<Integer> inputArray, int depth) {
        if (inputArray.size() > 2) {
            List<Integer> first = inputArray.subList(0, inputArray.size() / 2);
            List<Integer> second = inputArray.subList(inputArray.size() / 2, inputArray.size());
            System.out.println(first.toString());
            System.out.println(second.toString());

            divideAndSort(first, depth++);
            divideAndSort(second, depth++);

            List<Integer> merge = new ArrayList<>();
            for (int i = 0; i < divideAndSort(first, depth++).size(); i++) {
                for (int j = 0; j < divideAndSort(second, depth++).size(); j++) {
                    if (divideAndSort(first, depth).get(i) < divideAndSort(second, depth).get(j)) {
                        merge.add(divideAndSort(second, depth).get(j));

                    } else {
                        merge.add(divideAndSort(second, depth).get(i));
                    }
                }
            }
            return merge;
        } else if (inputArray.size() == 2) {
            if (inputArray.get(0) > inputArray.get(1)) {
                int temp = inputArray.get(0);
                inputArray.set(0, inputArray.get(1));
                inputArray.set(1, temp);
            }
            System.out.println("X" + depth);
            System.out.println(inputArray.toString());

            return inputArray;
        } else if (inputArray.size() == 1) {
            System.out.println(inputArray.toString());
            return inputArray;
        } else {
            throw new IllegalArgumentException("this is not a legal Argument");
        }

    }
}
