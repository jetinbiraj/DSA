package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

import java.util.Stack;

public class MinStack {

    static class Pair {
        int val;
        int min;

        Pair(int first, int second) {
            this.val = first;
            this.min = second;
        }
    }

    private Stack<Pair> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(new Pair(val, val));
            return;
        }

        minStack.push(new Pair(val, Math.min(minStack.peek().min, val)));
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek().val;
    }

    public int getMin() {
        return minStack.peek().min;
    }

//    class MinStack {
//        private Node head;
//
//        public void push(int x) {
//            if (head == null)
//                head = new Node(x, x, null);
//            else
//                head = new Node(x, Math.min(x, head.min), head);
//        }
//
//        public void pop() {
//            head = head.next;
//        }
//
//        public int top() {
//            return head.val;
//        }
//
//        public int getMin() {
//            return head.min;
//        }
//
//        private class Node {
//            int val;
//            int min;
//            Node next;
//
//            private Node(int val, int min, Node next) {
//                this.val = val;
//                this.min = min;
//                this.next = next;
//            }
//        }
//    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(4);
        minStack.push(3);
        minStack.push(2);

    }
}
