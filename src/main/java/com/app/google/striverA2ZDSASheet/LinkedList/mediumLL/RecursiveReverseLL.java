package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class RecursiveReverseLL {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = LinkedList.getLLFromArray(arr);

        Node reversedHead = recursiveReverseList(head);

        LinkedList.printLinkedList(reversedHead);
    }

    private static Node recursiveReverseList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = recursiveReverseList(head.next);

        Node front = head.next;

        front.next = head;
        head.next = null;

        return newHead;
    }

//    private static Node reverseNode(Node node, Node prev) {
//
//        if (node == null) {
//            return prev;
//        }
//
//        Node next = node.next;
//        node.next = prev;
//
//        return reverseNode(next, node);
//    }

}
