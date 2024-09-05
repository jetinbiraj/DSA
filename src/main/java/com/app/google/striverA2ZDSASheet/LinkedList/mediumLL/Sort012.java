package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class Sort012 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 2, 0, 2, 2};
        Node head = LinkedList.getLLFromArray(arr);

        Node newHead = bruteForceSegregate(head);
//        Node newHead = betterSegregate(head);
        LinkedList.printLinkedList(newHead);
    }

    private static Node betterSegregate(Node head) {

        Node zeroListHead = new Node();
        Node oneListHead = new Node();
        Node twoListHead = new Node();

        Node zeroList = zeroListHead;
        Node oneList = oneListHead;
        Node twoList = twoListHead;

        Node current = head;

        while (current != null) {

            if (current.data == 0) {
                zeroList.next = current;
                zeroList = current;
            } else if (current.data == 1) {
                oneList.next = current;
                oneList = current;
            } else {
                twoList.next = current;
                twoList = current;
            }

            current = current.next;
        }

        zeroList.next = oneListHead.next != null ? oneListHead.next : twoListHead.next;
        oneList.next = twoListHead.next;
        twoList.next = null;

        return zeroListHead.next;
    }

    private static Node bruteForceSegregate(Node head) { //2.41

        Node current = head;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        while (current != null) {
            if (current.data == 0) {
                count0++;
            } else if (current.data == 1) {
                count1++;
            } else {
                count2++;
            }
            current = current.next;
        }

        current = head;

        while (current != null) {
            while (count0 > 0) {
                current.data = 0;
                count0--;
                current = current.next;
            }
            while (count1 > 0) {
                current.data = 1;
                count1--;
                current = current.next;
            }
            while (count2 > 0) {
                current.data = 2;
                count2--;
                current = current.next;
            }
        }

        return head;
    }
}
