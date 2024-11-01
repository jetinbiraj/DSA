package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

public class StackULinkedList {

    static class LinkedList {

        int data;
        LinkedList next;

        LinkedList(int a) {
            data = a;
            next = null;
        }
    }

    private LinkedList top;

    void push(int a) {
        LinkedList node = new LinkedList(a);

        node.next = top;
        top = node;
    }

    int pop() {

        if (top == null) {
            return -1;
        }

        int topElement = top.data;
        top = top.next;

        return topElement;
    }

    public static void main(String[] args) {
        StackULinkedList stack = new StackULinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
