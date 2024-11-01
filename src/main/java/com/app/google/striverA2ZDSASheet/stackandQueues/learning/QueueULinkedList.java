package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

public class QueueULinkedList {

    static class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    private static QueueNode front, rear;

    public void push(int a) {
        QueueNode node = new QueueNode(a);

        if (front == null) {
            front = rear = node;
            return;
        }

        rear.next = node;
        rear = node;

    }

    public int pop() {

        if (front == null) {
            return -1;
        }

        int frontElement = front.data;

        front = front.next;
        if (front == null) {
            rear = null;
        }
        return frontElement;
    }

    public static void main(String[] args) {
        QueueULinkedList queue = new QueueULinkedList();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
