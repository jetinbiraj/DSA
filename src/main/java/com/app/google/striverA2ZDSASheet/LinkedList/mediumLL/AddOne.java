package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class AddOne {

    public static void main(String[] args) {  //9 -> 9 -> 9 , 4 -> 5 -> 6

//        int[] arr = {4, 5, 6};
        int[] arr = {1, 9, 9};
//        int[] arr = {9, 9, 9};
        Node head = LinkedList.getLLFromArray(arr);

//        Node newHead = bruteForceAddOne(head);
        Node newHead = optimalAddNode(head);

        LinkedList.printLinkedList(newHead);
    }

    private static Node optimalAddNode(Node head) {

        int carry = addNode(head);

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    private static int addNode(Node node) {

        if (node == null) {
            return 1;
        }

        int carry = addNode(node.next);

        node.data = node.data + carry;

        if (node.data >= 10) {
            node.data = 0;
            return 1;
        }
        return 0;
    }

    private static Node bruteForceAddOne(Node head) {

        Node reversedHead = reverseLL(head);

        Node current = reversedHead;
        int carry = 1;

        while (current != null) {

            int num = current.data + carry;
            if (num >= 10) {
                current.data = num % 10;
            } else {
                current.data = num;
                carry = 0;
                break;
            }
            current = current.next;
        }

        reversedHead = reverseLL(reversedHead);

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = reversedHead;
            return newNode;
        }

        return reversedHead;
    }


    private static Node reverseLL(Node head) {

        Node current = head;
        Node prev = null;

        while (current != null) {

            Node next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
