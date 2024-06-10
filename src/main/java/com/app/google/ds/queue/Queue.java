package com.app.google.ds.queue;

public class Queue {
    private int[] items;//  [1, 1 , 1 , 1 , 1]
    private int size;

    private int front, rear;

    public Queue(int size) {
        this.items = new int[size];
        this.size = size;
        this.front = this.rear = -1;
    }

    private boolean isFull() {

        return front == 0 && rear == size - 1;

    }

    private boolean isEmpty() {

        return front == -1;

    }

    private void enQueue(int element) {

        if (isFull()) {
            System.out.println("Queue is already full!");
            return;
        }

        if (front == -1) {
            front++;
        }

        if (rear >= size - 1) {
            System.out.println("Queue end limit has reached!, Could not insert new element");
            return;
        }
        items[++rear] = element;

    }

    private void deQueue() {

        if (isEmpty()) {
            System.out.println("Queue is already empty!");
            return;
        }

        if (front >= rear) {
            front = -1;
            rear = -1;
            System.out.println("Queue has been reset!");
        } else {
            front++;
            System.out.println("Removed element from the queue!");
        }

    }

    private void display() {

        int i;

        if (isEmpty()) {
            System.out.println("Queue is empty, nothing to display");
            return;
        }

        System.out.println("Items in the Queue are: ");
        for (i = front; i <= rear; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.deQueue();

        // enQueue 5 elements
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        // 6th element can't be added to because the queue is full
        queue.enQueue(6);
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();

        queue.enQueue(12);
        queue.display();

    }
}
