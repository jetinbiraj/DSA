package com.app.google.striverA2ZDSASheet.LinkedList.mediumDLL;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 8, 9};
        int[] duplicateElementArr = {1};

        Node head = Node.dllFromArray(arr);
        Node duplicateHead = Node.dllFromArray(duplicateElementArr);

        duplicateHead.next = duplicateHead;
        duplicateHead.next.back = duplicateHead;
        duplicateHead.next.next = head;

//        Node removedDuplicateHead = bruteForceRemoveDuplicates(duplicateHead);
        Node removedDuplicateHead = optimalRemoveDuplicates(duplicateHead);

        Node.printDLL(removedDuplicateHead);
    }

    private static Node optimalRemoveDuplicates(Node head) {

        Node current = head;

        while(current != null) {

            Node nextNode = current.next;

            while(nextNode != null && nextNode.data == current.data){
                nextNode= nextNode.next;
            }

            if(nextNode != null) {
                nextNode.back = current;
            }
            current.next = nextNode;
            current = current.next;
        }

        return head;
    }

    private static Node bruteForceRemoveDuplicates(Node head) {

        Set<Integer> set = new HashSet<>();
        Node current = head;

        while (current != null) {

            if (set.contains(current.data)) {
                Node prev = current.back;
                Node next = current.next;

                prev.next = next;

                if (next != null) {
                    next.back = prev;
                }
            } else {
                set.add(current.data);
            }

            current = current.next;
        }

        return head;
    }
}
