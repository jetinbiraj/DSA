package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

public class QueueUArray {

    static class Queue {
        private final int[] queue;
        private int size;
        private int front;
        private int rear;
        private int capacity;


        public Queue(int capacity) {
            this.queue = new int[capacity];
            this.front = -1;
            this.rear = -1;
            this.size = 0;
            this.capacity = capacity;
        }

        public void push(int element) {

            if (!isFull()) {
                if (size == 0) {
                    front = rear = 0;
                } else {
                    rear = (rear + 1) % this.capacity;
                }

                queue[rear] = element;
                this.size++;
            } else {
                System.out.println("Queue is full");
            }
        }

        public int pop() {

            if (!isEmpty()) {

                int element = queue[front];

                if (this.size == 1) {
                    front = rear = 0;
                } else {
                    front = (front + 1) % capacity;
                }

                this.size--;
                return element;
            } else {
                System.out.println("Queue is empty");
            }
            return -1;
        }

        public int top() {
            if (!isEmpty()) {
                return queue[front];
            } else {
                System.out.println("Queue is empty");
            }
            return -1;
        }

        private boolean isEmpty() {
            return this.size == 0;
        }

        private boolean isFull() {
            return this.size == queue.length;
        }
    }


    public static void main(String[] args) {

        Queue queue = new Queue(3);

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(4);
        System.out.println(queue.pop());
    }
}
