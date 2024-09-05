package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {

        int[] arr = {1, 2};

        Node head = LinkedList.getLLFromArray(arr);

        System.out.println(bruteForceIsPalindrome(head));
        System.out.println(betterIsPalindrome(head));
        System.out.println(optimalIsPalindrome(head));
    }

    private static boolean optimalIsPalindrome(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = slow;
        slow = slow.next;
        prev.next = null;

        while (slow != null) {
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        fast = head;
        slow = prev;

        while (slow != null) {

            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static boolean betterIsPalindrome(Node head) {

        Stack<Integer> stack = new Stack<>();

        Node current = head;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;

        while (current != null) {
            if (stack.pop() != current.data) {
                return false;
            }
            current = current.next;
        }

        return true;
    }


    private static boolean bruteForceIsPalindrome(Node head) {

        StringBuilder sb = new StringBuilder();

        Node current = head;

        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }

        return isPalindrome(sb.toString(), 0, sb.length() - 1);
    }

    private static boolean isPalindrome(String str, int startIndex, int lastIndex) {

        if (startIndex >= lastIndex) {
            return true;
        }

        if (str.charAt(startIndex) == str.charAt(lastIndex)) {
            return isPalindrome(str, startIndex + 1, lastIndex - 1);
        } else {
            return false;
        }
    }
}
