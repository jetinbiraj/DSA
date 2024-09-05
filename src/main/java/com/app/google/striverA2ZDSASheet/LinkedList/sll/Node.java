package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class Node {

    private int data;
    private Node next;

    public Node() {
        this.data = 0;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
