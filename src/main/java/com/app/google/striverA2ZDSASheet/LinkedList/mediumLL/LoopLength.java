package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.HashMap;
import java.util.Map;

public class LoopLength {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = LinkedList.getLLFromArray(arr);

        makeCycle(head.next.next);

        System.out.println(bruteForceNodesInLoop(head));
        System.out.println(optimalNodesInLoop(head));
    }

    private static int optimalNodesInLoop(Node head) {

        Node fast = head;
        Node slow = head;
        int nodesInLoop = 0;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow.equals(fast)) {

               fast = fast.next;
                nodesInLoop++;

                while (fast != slow) {
                    nodesInLoop++;
                    fast = fast.next;
                }
                return nodesInLoop;
            }
        }

        return nodesInLoop;
    }

    private static int bruteForceNodesInLoop(Node head) {

        Map<Node, Integer> trackMap = new HashMap<>();

        Node current = head;

        int counter = 1;

        while (current.next != null) {

            if (trackMap.containsKey(current)) {
                return counter - trackMap.get(current);
            }

            trackMap.put(current, counter++);

            current = current.next;
        }

        return 0;
    }

    private static void makeCycle(Node node) {

        Node current = node;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }
}
