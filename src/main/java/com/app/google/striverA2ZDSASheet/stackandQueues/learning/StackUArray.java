package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

public class StackUArray {

    private static class Stack {

        private int[] stack;
        private int size;
        private int top;

        public Stack(int size) {
            this.stack = new int[size];
            this.top = -1;
        }

        public void push(int num) {

            if (!isFull()) {
                stack[++top] = num;
            } else {
                System.out.println("Stack is full!");
            }
        }

        public int pop() {
            if (!isEmpty()) {
                return stack[top--];
            } else {
                System.out.println("Stack is empty!");
                return -1;
            }
        }

        public int top() {
            if (!isEmpty()) {
                return stack[top];
            } else {
                System.out.println("Stack is empty!");
                return -1;
            }
        }

        public int size() {
            return top;
        }

        public int capacity() {
            return this.stack.length;
        }

        private boolean isFull() {
            return top == stack.length - 1;
        }

        private boolean isEmpty() {
            return top == -1;
        }

        private void printStack() {
            for (int i = this.top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        stack.printStack();
        System.out.println(stack.size());
        System.out.println(stack.capacity());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);

        stack.printStack();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.printStack();

        System.out.println(stack.top());

    }
}
