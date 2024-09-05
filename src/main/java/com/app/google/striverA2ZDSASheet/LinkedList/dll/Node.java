package com.app.google.striverA2ZDSASheet.LinkedList.dll;

public class Node {
    private int data;
    private Node next;
    private Node back;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
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

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }
}
