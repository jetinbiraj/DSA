package com.app.google.ds.queue;

public class DEQueue {

    private int[] arr;
    private int size, front, rear;

    public DEQueue(int size) {
        arr = new int[size];
        this.size = size;
        front = rear = -1;
    }

    private boolean isFull() {

        return (front == 0 && rear == size - 1) || front == rear + 1;

    }

    private boolean isEmpty() {

        return front == -1;

    }

    private void enqueueFront(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        arr[front] = element;

        System.out.println("element inserted at front!");
    }

    private void enqueueRear(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        if (rear == size - 1) {
            rear = (rear + 1) % size;
        } else {
            rear++;
        }

        arr[rear] = element;

        System.out.println("element inserted at end!");
    }

    private void dequeueFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = (front + 1) % size;
        } else {
            front++;
        }

    }

    private void dequeueRear() {

        if (isEmpty()) {
            System.out.println("queue is empty!");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    private int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return arr[front];
    }

    private int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return arr[rear];
    }


    private void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty, Nothing to display!");
            return;
        }

    }

    public static void main(String[] args) {

        DEQueue dq = new DEQueue(4);

        System.out.println("Insert element at rear end : 12 ");
        dq.enqueueRear(12);

        System.out.println("insert element at rear end : 14 ");
        dq.enqueueRear(14);

        System.out.println("get rear element : " + dq.getRear());

        dq.dequeueRear();
        System.out.println("After delete rear element new rear become : " + dq.getRear());

        System.out.println("inserting element at front end");
        dq.enqueueFront(13);

        System.out.println("get front element: " + dq.getFront());

        dq.dequeueFront();

        System.out.println("After delete front element new front become : " + dq.getFront());


    }
}
