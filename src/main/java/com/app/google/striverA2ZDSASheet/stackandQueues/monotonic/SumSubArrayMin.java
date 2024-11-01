package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SumSubArrayMin {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 5};

        System.out.println(bruteForceSumSubArrayMins(arr));
        System.out.println(optimalSumSubArrayMins(arr));
    }

    private static int optimalSumSubArrayMins(int[] arr) {
        long sumSubarrayMins = 0;
        int n = arr.length;
        int mod = (int) (1e9 + 7);

        int[] prevSmallerEqualElementArr = new int[n];
        int[] nextSmallerElementIndexArr = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            prevSmallerEqualElementArr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            nextSmallerElementIndexArr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {

            sumSubarrayMins += (long) (i - prevSmallerEqualElementArr[i]) * (nextSmallerElementIndexArr[i] - i) % mod * arr[i] % mod;
            sumSubarrayMins %= mod;
        }

        return (int) (sumSubarrayMins);
    }

//    private static int[] nextSmallerElementIndexArr(int[] arr) {
//
//        int n = arr.length;
//        int[] nextSmallerElementIndexArr = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = n - 1; i >= 0; i--) {
//
//            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
//                stack.pop();
//            }
//
//            nextSmallerElementIndexArr[i] = stack.isEmpty() ? n : stack.peek();
//            stack.push(i);
//
//        }
//
//        return nextSmallerElementIndexArr;
//    }
//
//    private static int[] prevSmallerEqualElementArr(int[] arr) {
//        int n = arr.length;
//        int[] prevSmallerEqualElementArr = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//
//            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
//                stack.pop();
//            }
//
//            prevSmallerEqualElementArr[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//
//        return prevSmallerEqualElementArr;
//    }


    private static int bruteForceSumSubArrayMins(int[] arr) {

        long sumSubarrayMins = 0;
        int n = arr.length;
        long mod = (long) (1e9 + 7);

        for (int i = 0; i < n; i++) {

            sumSubarrayMins += arr[i];
            int min = arr[i];

            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, arr[j]);

                sumSubarrayMins = (sumSubarrayMins + min) % mod;
            }
        }

        return (int) (sumSubarrayMins % mod);
    }
}
