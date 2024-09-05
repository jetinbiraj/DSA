package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static void main(String[] args) {

        int[] arr = {6, 3, 2, 1, 5, 4};
        Node head = LinkedList.getLLFromArray(arr);

//        Node newHead = bruteForceSortList(head);
        Node newHead = optimalSortList(head);

        LinkedList.printLinkedList(newHead);
    }

    private static Node optimalSortList(Node node) {

        if (node == null || node.next == null) {
            return node;
        }

        Node middleNode = getMiddleNode(node);

        Node rightHead = middleNode.next;
        middleNode.next = null;

        Node leftHead = optimalSortList(node);
        rightHead = optimalSortList(rightHead);

        return merge(leftHead, rightHead);
    }

    private static Node getMiddleNode(Node head) {
        Node middleNode = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            middleNode = middleNode.next;
            fast = fast.next.next;
        }

        return middleNode;
    }

    private static Node merge(Node leftNode, Node rightNode) {

        Node mergedListHead = new Node();

        Node mergedList = mergedListHead;

        while (leftNode != null && rightNode != null) {

            if (leftNode.data < rightNode.data) {
                mergedList.next = leftNode;
                leftNode = leftNode.next;
            } else {
                mergedList.next = rightNode;
                rightNode = rightNode.next;
            }
            mergedList = mergedList.next;
        }

        if (leftNode != null) {
            mergedList.next = leftNode;
        } else {
            mergedList.next = rightNode;
        }

        return mergedListHead.next;
    }


//    private static Node optimalSortList(Node node) {
//
//        if (node == null || node.next == null) {
//            return node;
//        }
//
//        Node middleNode = getMiddleNode(node);
//
//        Node rightHead = middleNode.next;
//        middleNode.next = null;
//
//        Node leftHead = optimalSortList(node);
//        rightHead = optimalSortList(rightHead);
//
//        return merge(leftHead, rightHead);
//    }
//
//    private static Node merge(Node leftNode, Node rightNode) {
//
//        Node leftCurrent = leftNode;
//        Node rightCurrent = rightNode;
//
//        Node newNode = new Node();
//        Node newNodeCurrent = newNode;
//
//        while (leftCurrent != null && rightCurrent != null) {
//
//            if (leftCurrent.data < rightCurrent.data) {
//
//                newNodeCurrent.next = leftCurrent;
//                newNodeCurrent = leftCurrent;
//                leftCurrent = leftCurrent.next;
//            } else {
//                newNodeCurrent.next = rightCurrent;
//                newNodeCurrent = rightCurrent;
//                rightCurrent = rightCurrent.next;
//            }
//        }
//
//        if (leftCurrent != null) {
//            newNodeCurrent.next = leftCurrent;
//        } else {
//            newNodeCurrent.next = rightCurrent;
//        }
//
//        return newNode.next;
//    }
//
//    private static Node getMiddleNode(Node head) {
//        Node current = head.next;
//        Node middleNode = head;
//
//        while (current != null && current.next != null) {
//
//
//            middleNode = middleNode.next;
//
//            current = current.next.next;
//        }
//
//        return middleNode;
//    }

    private static Node bruteForceSortList(Node head) {

        List<Integer> list = new ArrayList<>();

        Node current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        current = head;
        Collections.sort(list);

        for (int num : list) {
            current.data = num;
            current = current.next;
        }

        return head;
    }
}
