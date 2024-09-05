package com.app.google.striverA2ZDSASheet.LinkedList.mediumDLL;

public class DeleteOccurrences {

    public static void main(String[] args) {

        int[] arr = {2, 2, 10, 8, 4, 2, 5, 2};
        Node dllHead = Node.dllFromArray(arr);

//        Node newDllHead = bruteForceDeleteAllOccurOfX(dllHead, 2);
//        Node newDllHead = optimalDeleteAllOccurOfX(dllHead, 2);
        Node newDllHead = betterDeleteAllOccurOfX(dllHead, 2);

        Node.printDLL(newDllHead);
    }

    private static Node optimalDeleteAllOccurOfX(Node head, int x) { //2<->2<->10<->8<->4<->2<->5<->2

        Node current = head;
        Node dummy = new Node();
        Node resultHead = dummy;
        Node prev = null;

        while (current != null) {

            if (current.data != x) {
                dummy.next = current;
                dummy.back = prev;
                prev = current;
                dummy = dummy.next;
            }

            current = current.next;
        }
        dummy.next = null;

        return resultHead.next;
    }

    private static Node betterDeleteAllOccurOfX(Node head, int x) {
        Node current = head;

        while (current != null) {

            if (current.data == x) {

                if (current.equals(head)) {
                    head = current.next;
                }

                Node next = current.next;
                Node prev = current.back;

                if (next != null) {
                    next.back = prev;
                }

                if (prev != null) {
                    prev.next = next;
                }

            }

            current = current.next;
        }

        return head;
    }


    private static Node bruteForceDeleteAllOccurOfX(Node head, int x) { //2<->2<->10<->8<->4<->2<->5<->2

        Node current = head;
        Node newDll = new Node();
        Node resultDll = newDll;

        Node prev = null;

        while (current != null) {

            if (current.data != x) {

                Node newNode = new Node(current.data, null, prev);
                prev = newNode;
                newDll.next = newNode;
                newDll = newDll.next;
            }
            current = current.next;
        }

        return resultDll.next;
    }
}
