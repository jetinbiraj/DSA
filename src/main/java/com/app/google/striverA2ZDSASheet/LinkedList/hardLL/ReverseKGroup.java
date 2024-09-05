package com.app.google.striverA2ZDSASheet.LinkedList.hardLL;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = LinkedList.getLLFromArray(arr);

        int k = 3;

//        Node newNode = bruteForceReverseKGroup(head, k);
//        Node newNode = betterReverseKGroup(head, k);
//        Node newNode = recursiveReverseKGroup(head, k);
        Node newNode = iterativeReverseKGroup(head, k);

        LinkedList.printLinkedList(newNode);
    }

    private static Node iterativeReverseKGroup(Node head, int k) {

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node kthNode = getKthNode(current, k);

            if (kthNode == null) {
                if (prev != null) {
                    prev.next = current;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;

            optimalReverseList(current);

            if (current == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = current;
            current = nextNode;
        }
        return head;
    }

    private static Node optimalReverseList(Node head) {

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

    private static Node getKthNode(Node current, int k) {
        Node temp = current;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    private static Node recursiveReverseKGroup(Node head, int k) {

        Node current = head;
        int count = 0;

        while (current != null && count != k) {
            current = current.next;
            count++;
        }

        if (count == k) {

            current = recursiveReverseKGroup(current, k);

            while (count-- > 0) {

                Node next = head.next;
                head.next = current;
                current = head;
                head = next;
            }
            head = current;
        }
        return head;
    }

    private static Node betterReverseKGroup(Node head, int k) {

        int[] arr = new int[k];

        Node current = head;

        while (current != null) {

            Node mover = current;
            int index = 0;

            while (index < arr.length && mover != null) {
                arr[index++] = mover.data;
                mover = mover.next;
            }

            if (index < arr.length) {
                break;
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                current.data = arr[i];
                current = current.next;
            }
        }
        return head;
    }


    private static Node bruteForceReverseKGroup(Node head, int k) {

        Node current = head;
        List<Integer> list = new ArrayList<>();

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        int listLength = list.size();

        for (int i = 0; i < listLength; i = i + k) {

            int m = i;
            int n = i + k - 1;
            if (n >= listLength) {
                break;
            }

            while (m < n) {
                int temp = list.get(m);
                list.set(m++, list.get(n));
                list.set(n--, temp);
            }
        }

        current = head;
        for (int num : list) {
            current.data = num;
            current = current.next;
        }

        return head;
    }
}
