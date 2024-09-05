package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    public static void main(String[] args) {

        int[] arrA = {6, 3, 2, 1, 5, 4};
        int[] arrB = {3, 4};
        Node headA = LinkedList.getLLFromArray(arrA);

        Node headB = LinkedList.getLLFromArray(arrB);

        headB.next.next = headA.next.next;

//        Node intersectionNode = bruteForceGetIntersectionNode(headA, headB);
//        Node intersectionNode = betterGetIntersectionNode(headA, headB);
//        Node intersectionNode = better2GetIntersectionNode(headA, headB);
        Node intersectionNode = optimalGetIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println(intersectionNode.data);
        } else {
            System.out.println("intersection node not found");
        }
    }

    private static Node optimalGetIntersectionNode(Node headA, Node headB) {

        Node currentA = headA;
        Node currentB = headB;

        while (currentA != null && currentB != null) {

            if (currentA.equals(currentB)) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;

            if (currentA == null && currentB == null) {
                return null;
            } else if (currentA == null) {
                currentA = headB;
            } else if (currentB == null) {
                currentB = headA;
            }
        }

        return null;
    }

    private static Node better2GetIntersectionNode(Node headA, Node headB) {

        Node currentA = headA;
        Node currentB = headB;

        int countA = 1;
        int countB = 1;

        while (currentA != null) {
            currentA = currentA.next;
            countA++;
        }

        while (currentB != null) {
            currentB = currentB.next;
            countB++;
        }

        currentB = headB;
        currentA = headA;

        if (countA < countB) {
            return collisionPoint(currentB, currentA, countB - countA);
        }
        return collisionPoint(currentA, currentB, countA - countB);
    }

    private static Node collisionPoint(Node headA, Node headB, int diff) {
        for (int i = 1; i <= diff; i++) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    private static Node betterGetIntersectionNode(Node headA, Node headB) {

        Node currentA = headA;
        Node currentB = headB;
        Set<Node> set = new HashSet<>();

        while (currentA != null) {

            set.add(currentA);
            currentA = currentA.next;
        }

        while (currentB != null) {
            if (set.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.next;
        }

        return null;
    }

    private static Node bruteForceGetIntersectionNode(Node headA, Node headB) {

        Node currentA = headA;

        while (currentA != null) {

            Node currentB = headB;
            while (currentB != null) {
                if (currentA.equals(currentB)) {
                    return currentA;
                }
                currentB = currentB.next;
            }

            currentA = currentA.next;
        }

        return null;
    }
}
