package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class SwapTwoNum {

    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        naiveSwapTwoNums(a, b);
        smartSwapTwoNums(a, b);
        bitWiseSwapTwoNums(a, b);
    }

    private static void bitWiseSwapTwoNums(int a, int b) {
        System.out.println("Before Swap");
        System.out.println("a: " + a + " b: " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swap");
        System.out.println("a: " + a + " b: " + b);
    }

    private static void smartSwapTwoNums(int a, int b) {
        System.out.println("Before Swap");
        System.out.println("a: " + a + " b: " + b);

        a = a + b;

        b = a - b;
        a = a - b;

        System.out.println("After Swap");
        System.out.println("a: " + a + " b: " + b);
    }

    private static void naiveSwapTwoNums(int a, int b) {
        System.out.println("Before Swap");
        System.out.println("a: " + a + " b: " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After Swap");
        System.out.println("a: " + a + " b: " + b);
    }
}
