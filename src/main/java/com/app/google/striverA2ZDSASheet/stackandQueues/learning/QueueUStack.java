package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

import java.util.Stack;

public class QueueUStack {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

//    private Stack<Integer> stack;
//    private Stack<Integer> tempStack;
//
//    public QueueUStack() {
//        stack = new Stack<>();
//        tempStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        while(!stack.isEmpty()) {
//            tempStack.push(stack.pop());
//        }
//
//        stack.push(x);
//
//        while(!tempStack.isEmpty()){
//            stack.push(tempStack.pop());
//        }
//    }
//
//    public int pop() {
//        return stack.pop();
//    }
//
//    public int peek() {
//        return stack.peek();
//    }
//
//    public boolean empty() {
//        return stack.isEmpty();
//    }

    public static void main(String[] args) {


    }
}
