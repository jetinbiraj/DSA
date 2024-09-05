package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class SearchNode {

    public static void main(String[] args) {
        Node head = LinkedList.getLLFromArray(new int[]{1, 2, 3, 4, 5, 6});


        System.out.println(searchKey(head, 678));
    }

    private static boolean searchKey(Node head, int key) {

        Node currentNode = head;

        while (currentNode.getNext() != null) {
            if (currentNode.getData() == key) {
                return true;
            }

            currentNode = currentNode.getNext();
        }
        return false;
    }
}
