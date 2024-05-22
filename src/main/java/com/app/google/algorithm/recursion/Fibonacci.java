package com.app.google.algorithm.recursion;

public class Fibonacci {

    public static void main(String[] args) {

        int num = 6;

        System.out.println(nThTerm(num));

    }

    private static int nThTerm(int n) {

        if (n <= 1) {
            return 1;
        }
        //5+4+3+2+1+1, 0,1,1,2,3,5,8,13,

        int last = nThTerm(n-1);
        int secondLast = nThTerm(n-2);

        return last+secondLast;
    }
}
