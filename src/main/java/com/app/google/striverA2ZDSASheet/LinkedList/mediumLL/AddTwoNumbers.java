package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class AddTwoNumbers {

    public static void main(String[] args) {

//        int[] arr1 = {2, 4, 3};
//        int[] arr2 = {5, 6, 4};
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};
        Node l1 = LinkedList.getLLFromArray(arr1);
        Node l2 = LinkedList.getLLFromArray(arr2);

        Node resultHead = addTwoNumbers(l1, l2);

        LinkedList.printLinkedList(resultHead);
    }

    private static Node addTwoNumbers(Node l1, Node l2) {

        Node node = new Node();
        Node resultList = node;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {

            int num = carry;

            if (l1 != null) {
                num += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                num += l2.data;
                l2 = l2.next;
            }

            Node newNode = new Node(num % 10);
            carry = num / 10;
            node.next = newNode;
            node = node.next;
        }

        return resultList.next;
    }
}
