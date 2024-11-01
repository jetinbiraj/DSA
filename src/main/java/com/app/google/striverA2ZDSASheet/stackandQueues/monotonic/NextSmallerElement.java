package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(List.of(4, 5, 2, 10, 8));

        System.out.println(bruteForcePrevSmaller(list));
        System.out.println(optimalForcePrevSmaller(list));
    }

    private static ArrayList<Integer> optimalForcePrevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : A) {
            int prevSmaller = -1;

            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prevSmaller = stack.peek();
            }

            stack.push(num);
            res.add(prevSmaller);
        }

        return res;
    }

    private static ArrayList<Integer> bruteForcePrevSmaller(ArrayList<Integer> A) {

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {

            int nearestSmallerElement = -1;

            for (int j = i - 1; j >= 0; j--) {

                if (A.get(j) < A.get(i)) {
                    nearestSmallerElement = A.get(j);
                    break;
                }
            }

            res.add(nearestSmallerElement);
        }

        return res;
    }
}
