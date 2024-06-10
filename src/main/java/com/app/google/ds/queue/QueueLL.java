package com.app.google.ds.queue;

public class QueueLL {

    Node front, rear;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private void enQueue(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            System.out.println("Head is inserted!");
            return;
        }

        rear.next = newNode;
        rear = newNode;

        System.out.println("New node has been inserted!");
    }

    private int deQueue() {

        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int element = front.value;

        front = front.next;
        System.out.println("\nElement has been removed");

        if (front == null) {
            rear = null;
        }
        return element;
    }

    private void display() {

        if (front == null) {
            System.out.println("Queue is empty, Nothing to display!");
            return;
        }

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        QueueLL queue = new QueueLL();

        queue.display();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        queue.display();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.display();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        queue.display();
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.display();
    }
}
