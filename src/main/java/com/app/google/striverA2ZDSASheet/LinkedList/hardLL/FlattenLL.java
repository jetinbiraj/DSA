package com.app.google.striverA2ZDSASheet.LinkedList.hardLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenLL {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    public static void main(String[] args) {


    }

    private static Node recursiveFlatten(Node root) {

        if (root.next == null) {
            return root;
        }

        Node list2 = recursiveFlatten(root.next);
        root.next = null;

        return mergeList(root, list2);
    }

    private static Node mergeList(Node list1, Node list2) {

        Node current1 = list1;
        Node current2 = list2;
        Node newNode = new Node(-1);
        Node dummy = newNode;

        while (current1 != null && current2 != null) {

            if (current1.data < current2.data) {
                dummy.bottom = current1;
                current1 = current1.bottom;
            } else {
                dummy.bottom = current2;
                current2 = current2.bottom;
            }
            dummy = dummy.bottom;

        }

        if (current1 != null) {
            dummy.bottom = current1;
        } else {
            dummy.bottom = current2;
        }

        return newNode.bottom;
    }

    private static Node betterFlatten(Node root) {

        Node current = root;

        while (current.next != null) {
            Node nextList = current.next;
            current.next = null;
            current = merge(current, nextList);
        }
        return current;
    }

    private static Node merge(Node currentList, Node nextList) {

        Node temp1 = currentList;
        Node temp2 = nextList;
        Node newList = new Node(-1);
        Node current = newList;

        while (temp1 != null && temp2 != null) {

            if (temp1.data < temp2.data) {
                current.bottom = temp1;
                temp1 = temp1.bottom;
            } else {
                current.bottom = temp2;
                temp2 = temp2.bottom;
            }
            current = current.bottom;
        }

        if (temp1 != null) {
            current.bottom = temp1;
        } else {
            current.bottom = temp2;
        }

        currentList.next = nextList != null ? nextList.next : null;
        return newList.bottom;
    }


    private static Node bruteForceFlatten(Node root) {

        List<Integer> list = new ArrayList<>();

        Node current = root;

        while (current != null) {

            Node bt = current;

            while (bt != null) {
                list.add(bt.data);
                bt = bt.bottom;
            }

            current = current.next;
        }

        Collections.sort(list);

        Node newList = new Node(-1);
        current = newList;

        for (int num : list) {
            Node newNode = new Node(num);
            current.bottom = newNode;
            current = newNode;
        }

        return newList.bottom;
    }
}
