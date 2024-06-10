package com.app.google.ds.stack;

public class Stack {

    private int[] arr;

    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    private void push(int element) {

        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        arr[++top] = element;
    }

    private void pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty already");
            return;

        }

        arr[top--] = 0;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    private void printStack() {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Stack stack = new Stack(5);

        stack.printStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("after pushing in: ");
        stack.printStack();

        stack.pop();

        System.out.println("after popping out: ");
        stack.printStack();
    }
}
