package com.app.google.striverA2ZDSASheet.LinkedList.hardLL;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    private static Node optimalCopyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {

            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;

            current = current.next.next;
        }

        current = head;

        while (current != null) {

            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        current = head;

        Node CopiedList = head.next;

        while (current != null && current.next != null) {

            Node next = current.next;

            current.next = current.next.next;
            current = next;
        }

        return CopiedList;
    }

    private static Node bruteForceCopyRandomList(Node head) {

        Node current = head;

        Map<Node, Node> map = new HashMap<>();

        while (current != null) {

            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        for (var entry : map.entrySet()) {

            Node keyNode = entry.getKey();
            Node valueNode = entry.getValue();

            valueNode.next = map.get(keyNode.next);

            valueNode.random = map.get(keyNode.random);
        }
        return map.get(head);
    }
}
