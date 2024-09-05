package com.app.google.striverA2ZDSASheet.LinkedList.mediumDLL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

    public static void main(String[] args) {


        int[] arr = {1, 2, 4, 5, 6, 8, 9};

        Node head = Node.dllFromArray(arr);

        System.out.println(bruteForceFindPairsWithGivenSum(7, head));
        System.out.println(betterFindPairsWithGivenSum(7, head));
        System.out.println(optimalFindPairsWithGivenSum(7, head));
    }

    private static List<List<Integer>> optimalFindPairsWithGivenSum(int target, Node head) {

        List<List<Integer>> pairs = new ArrayList<>();

        Node current = head;

        while (current.next != null) {
            if (current.data > target) {
                break;
            }
            current = current.next;
        }

        Node tail = current;
        current = head;

        while (current.data < tail.data) {

            int num = current.data + tail.data;

            if (num == target) {
                pairs.add(List.of(current.data, tail.data));
                current = current.next;
                tail = tail.back;
            } else if (num < target) {
                current = current.next;
            } else {
                tail = tail.back;
            }
        }

        return pairs;
    }


    private static List<List<Integer>> betterFindPairsWithGivenSum(int target, Node head) {

        List<List<Integer>> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        Node current = head;

        while (current != null) {

            if (current.data > target) {
                break;
            }

            int diff = target - current.data;
            if (set.contains(diff)) {
                pairs.add(List.of(diff, current.data));
            } else {
                set.add(current.data);
            }

            current = current.next;
        }

        return pairs;
    }


    private static List<List<Integer>> bruteForceFindPairsWithGivenSum(int target, Node head) {

        List<List<Integer>> pairs = new ArrayList<>();

        Node current = head;

        while (current != null) {

            Node nextCurrent = current.next;

            while (nextCurrent != null) {

                int num = current.data + nextCurrent.data;

                if (num == target) {
                    pairs.add(List.of(current.data, nextCurrent.data));
                } else if (num > target) {
                    break;
                }
                nextCurrent = nextCurrent.next;
            }

            current = current.next;
        }

        return pairs;
    }
}
