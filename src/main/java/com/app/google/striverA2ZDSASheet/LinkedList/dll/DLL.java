package com.app.google.striverA2ZDSASheet.LinkedList.dll;

public class DLL {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Node head = bruteForceArrayToDll(arr);
//        Node head = dllFromArray(arr);

//        Node newHead = deleteHeadOfDll(head);
//        Node newHead = deleteTailOfDll(head);
//        Node newHead = deleteKthNode(head, 3);
//        deleteNode(head.getNext().getNext());
//        Node newHead = insertBeforeHead(head, 7);
//        Node newHead = insertBeforeTail(head, 7);
//        Node newHead = insertBeforeKthElement(head, 7, 3);
        insertBeforeNode(head.getNext(), 11);

        printDLL(head);

    }

    private static void insertBeforeNode(Node node, int data) {

        Node newNode = new Node(data, node, node.getBack());

        node.setBack(newNode);
        node.getBack().setNext(newNode);
    }

    private static Node insertBeforeKthElement(Node head, int data, int k) {

        Node current = head;

        int counter = 0;

        while (current != null) {
            if (++counter == k) {
                break;
            }

            current = current.getNext();
        }

        if (current == null) {
            return head;
        }

        Node prev = current.getBack();
        if (prev == null) {
            return insertBeforeHead(head, data);
        } else {
            Node newNode = new Node(data, current, prev);
            prev.setNext(newNode);
        }

        return head;
    }

    private static Node insertBeforeTail(Node head, int data) {

        if (head.getNext() == null) {
            return insertBeforeHead(head, data);
        }

        Node current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        Node prev = current.getBack();

        Node newNode = new Node(data, current, prev);

        current.setBack(newNode);
        prev.setNext(newNode);

        return head;
    }

    private static Node insertBeforeHead(Node head, int data) {
        Node newHead = new Node(data, head, null);

        head.setBack(newHead);
        return newHead;
    }

    private static void deleteNode(Node node) {

        if (node == null) {
            return;
        }

        Node back = node.getBack();
        Node next = node.getNext();

        node.setNext(null);
        node.setBack(null);

        back.setNext(next);
        if (next != null) {
            next.setBack(back);
        }
    }

    private static Node deleteKthNode(Node head, int k) {

        if (head == null) {
            return null;
        }

        Node current = head;
        int counter = 0;

        while (current != null) {
            if (++counter == k) {
                break;
            }
            current = current.getNext();
        }

        if (current == null) {
            return head;
        }

        Node next = current.getNext();
        Node back = current.getBack();

        if (next == null && back == null) {
            return null;
        } else if (next == null) {
            return deleteTailOfDll(head);
        } else if (back == null) {
            return deleteHeadOfDll(head);
        }

        back.setNext(next);
        next.setBack(back);
        current.setBack(null);
        current.setNext(null);
        return head;
    }

    private static Node deleteTailOfDll(Node node) {

        if (node == null || (node.getBack() == null && node.getNext() == null)) {
            return null;
        }

        Node current = node;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        Node tail = current.getBack();
        tail.setNext(null);
        current.setBack(null);
        return node;
    }

    private static Node deleteHeadOfDll(Node node) {

        if (node == null || (node.getNext() == null && node.getBack() == null)) {
            return null;
        }

        Node current = node;

        while (current.getBack() != null) {
            current = current.getBack();
        }

        Node head = current.getNext();

        head.setBack(null);
        current.setNext(null);
        return head;
    }


    public static Node dllFromArray(int[] arr) {

        Node head = new Node(arr[0]);

        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, prev);
            prev.setNext(newNode);
            prev = newNode;
        }

        return head;
    }


    private static Node bruteForceArrayToDll(int[] arr) {

        Node head = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);

            Node cursor = head;
            while (cursor.getNext() != null) {

                cursor = cursor.getNext();
            }

            cursor.setNext(newNode);
            newNode.setBack(cursor);
        }

        return head;
    }

    public static void printDLL(Node head) {

        if (head == null) {
            System.out.println("Empty doubly linked list...");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(head.getData()).append(" ");

        Node current = head;

        while (current.getNext() != null) {

            current = current.getNext();
            sb.append(current.getData()).append(" ");
        }

        System.out.println(sb);
    }
}
