package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class ArrayToLL {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        LinkedList.printLinkedList(bruteForceConstructLL(arr));
        LinkedList.printLinkedList(optimalConstructLL(arr));
    }

    private static Node optimalConstructLL(int[] arr) {

        Node head = new Node(arr[0]);

        Node tail = head;

        for (int i = 1; i < arr.length; i++) {

            Node node = new Node(arr[i]);
            tail.setNext(node);
            tail = node;
        }

        return head;
    }

    private static Node bruteForceConstructLL(int[] arr) {

        Node head = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            Node currentNode = head;

            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(new Node(arr[i]));
        }

        return head;
    }
}
