package com.app.google.striverA2ZDSASheet.dp.introduction;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;

        int count = 1;

//        System.out.println(n1 + " ");
        while (count++ < 19) {
//            System.out.println(n2 + " ");
            int temp = n1;
            n1 = n2;
            n2 = temp + n2;
        }

        System.out.println(n2);

//        FibonacciNumber obj = new FibonacciNumber();
//        System.out.println(obj.fib(19));
    }

    private int fib(int num) {
        return fib(num, new HashMap<>());
    }

    private int fib(int n, Map<Integer, Integer> map) {
        if (n <= 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, fib(n - 1, map) + fib(n - 2, map));

        return map.get(n);
    }
}
