package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

import java.util.LinkedList;
import java.util.Queue;

public class StackUQueue {

    Queue<Integer> queue;

    public StackUQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.add(x);
        int size = queue.size();

        for (int i = 1; i < size; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();

    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {


    }
}
