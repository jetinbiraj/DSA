package com.app.google.striverA2ZDSASheet.stackandQueues.implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    Deque<Integer> stack;
    Deque<int[]> oStack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
        this.oStack = new ArrayDeque<>();
    }

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.bruteForceNext(100));
        System.out.println(stockSpanner.bruteForceNext(80));
        System.out.println(stockSpanner.bruteForceNext(60));
        System.out.println(stockSpanner.bruteForceNext(70));
        System.out.println(stockSpanner.bruteForceNext(60));
        System.out.println(stockSpanner.bruteForceNext(75));
        System.out.println(stockSpanner.bruteForceNext(85));

        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));
        System.out.println(stockSpanner.optimalNext(85));

    }

    private int optimalNext(int price) {

        int span = 1;

        while (!oStack.isEmpty() && oStack.peek()[0] <= price) {
            span += oStack.pop()[1];
        }

        int[] pair = {price, span};
        oStack.push(pair);

        return span;
    }

    public int bruteForceNext(int price) {

        Deque<Integer> tempStack = new ArrayDeque<>();

        int span = 1;

        while (!stack.isEmpty() && stack.peek() <= price) {
            tempStack.push(stack.pop());
            span++;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        stack.push(price);

        return span;
    }
}
