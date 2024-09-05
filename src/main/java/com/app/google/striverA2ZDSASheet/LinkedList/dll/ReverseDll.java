package com.app.google.striverA2ZDSASheet.LinkedList.dll;

import java.util.Stack;

public class ReverseDll {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {null <- 1 <-> 2 <-> 3 <-> 4 <-> 5 -> null};  // 3 <-> 2 <-> 1 -> null

        Node head = DLL.dllFromArray(arr);

//        DLL.printDLL(bruteForceReverseDll(head));
        DLL.printDLL(optimalReverseDll(head));
    }

    private static Node optimalReverseDll(Node head) {

        Node current = head;
        Node last = null;

        while (current != null) {

            last = current.getBack();

            current.setBack(current.getNext());
            current.setNext(last);

            current = current.getBack();
        }

        return last;
    }

    private static Node bruteForceReverseDll(Node head) {

        Node current = head;

        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.getData());
            current = current.getNext();
        }

        current = head;

        while (current != null) {
            current.setData(stack.pop());
            current = current.getNext();
        }

        return head;
    }
}
