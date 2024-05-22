package com.app.google.ds.queue;

public class QueueY {

    private int[] arr;
    private int size;
    private int front, rear;

    public QueueY(int size) {
        arr = new int[size];
        this.size = size;
        this.front = 0;
        this.rear = -1;
    }

    private boolean isEmpty() {
        return rear == -1;
    }

    private boolean isFull() {
        return rear == size - 1;
    }

    private void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        arr[++rear] = element;
    }

    private int deQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return -1;
        }

        int element = arr[0];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;

        return element;
    }

    public int peek() {

        if (isEmpty()) {
            System.out.println("queue is empty!");
            return -1;
        }

        return arr[0];
    }

    private void display() {

        int i;

        if (isEmpty()) {
            System.out.println("Queue is empty, nothing to display");
            return;
        }

        System.out.println("Items in the Queue are: ");
        for (i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        QueueY queue = new QueueY(5);

        System.out.println("Deque element: " + queue.deQueue());

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
