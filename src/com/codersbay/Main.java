package com.codersbay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unsorted = Arrays.asList(5, 4, 1, 9, 6, 7, 3, 2, 8);
        List<Integer> mergeArray = new ArrayList<>();
        System.out.println("Sorted => " + divideAndSort(unsorted, mergeArray, 0));
    }

    private static List<Integer> divideAndSort(List<Integer> inputArray, List<Integer> mergeArray, int depth) {
        if (inputArray.size() > 1) {
            List<Integer> first = inputArray.subList(0, inputArray.size() / 2);
            List<Integer> second = inputArray.subList(inputArray.size() / 2, inputArray.size());
            //System.out.println(first.toString());
            // System.out.println(second.toString());
            List<Integer> merge = mergeArray;
            List<Integer> left = divideAndSort(first, merge, depth++);
            List<Integer> right = divideAndSort(second, merge, depth);


            System.out.println("l    " + left.toString());
            System.out.println("r    " + right.toString());



            /*for (int i = 0; i < left.size(); i++) {
                if (left.get(i) > right.get(i)) {
                    merge.add(right.get(i));

                } else {
                    merge.add(left.get(i));
                }
            }*/
    /*        for (int i = 0; i < left.size(); i++) {
                for (int j = 0; j < right.size(); j++) {

                    if (left.get(i) > right.get(j)) {

                        merge.add(right.get(j));
                    }
                    merge.add(right.get(j);
                }
            } */

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
            System.out.println("X" + depth);
            System.out.println(inputArray.toString());

            return inputArray;
        } else {
            throw new IllegalArgumentException("this is not a legal Argument");
        }

    }
}
