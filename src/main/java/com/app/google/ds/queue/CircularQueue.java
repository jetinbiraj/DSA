package com.app.google.ds.queue;

public class CircularQueue {
    private int[] arr;
    private int size;
    private int front, rear;

    public CircularQueue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = this.rear = -1;
    }

    private boolean isFull() {

        return (front == 0 && rear == size - 1) || (front == rear + 1);

    }

    private boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % size;
        arr[rear] = element;

        if (front == -1) {
            front = 0;
        }
        System.out.println("Element inserted!");
    }

    private int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            int element = arr[front];

            if (front == rear) {
                front = rear = -1;

            } else {
                front = (front + 1) % size;
            }

            return element;
        }
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front item: " + arr[front]);

        System.out.println("Items: ");

        int i;
        for (i = front; i != rear; i = (i + 1) % size) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[i]);
        System.out.println("\nRear item: " + arr[rear]);
    }


    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        // enQueue 5 elements
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        // 6th element can't be added to because the queue is full
        queue.enQueue(6);
        queue.display();

        System.out.println("Deque element: " + queue.deQueue());

        System.out.println("Deque element: " + queue.deQueue());

        System.out.println("Deque element: " + queue.deQueue());

        System.out.println("Deque element: " + queue.deQueue());

        System.out.println("Deque element: " + queue.deQueue());

        queue.enQueue(12);
        queue.display();
    }
}
