package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

//        [2,4,5],[1,3,4],[2,6]

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);

        ListNode[] lists = {l1, l2};

//        ListNode mergedNode = mergeKListsUsingPriorityQueue(lists);
//        ListNode mergedNode = bruteForceMergeKLists(lists);
        ListNode mergedNode = mergeKLists(lists);
    }

    private static ListNode mergeKLists(ListNode[] lists) {

        return mergeList(lists, 0, lists.length - 1);
    }

    private static ListNode mergeList(ListNode[] lists, int left, int right) {
        if (right < left) return null;
        if (right == left) return lists[right];

        int mid = (left + right) / 2;
        ListNode leftMergeList = mergeList(lists, left, mid), rightMergeList = mergeList(lists, mid + 1, right);

        ListNode dummy = new ListNode(0), cur = dummy;

        while (leftMergeList != null && rightMergeList != null) {
            if (leftMergeList.val < rightMergeList.val) {
                cur.next = leftMergeList;
                leftMergeList = leftMergeList.next;
            } else {
                cur.next = rightMergeList;
                rightMergeList = rightMergeList.next;
            }

            cur = cur.next;
        }

        cur.next = (leftMergeList != null) ? leftMergeList : rightMergeList;

        return dummy.next;
    }

    private static ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode list : lists) {

            ListNode current = list;

            while (current != null) {
                pq.offer(current);
                current = current.next;
            }
        }

        ListNode dummyHead = new ListNode();

        ListNode current = dummyHead;
        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
        }
        current.next = null;

        return dummyHead.next;
    }

    private static ListNode bruteForceMergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (ListNode listNode : lists) {

            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        Collections.sort(list);
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int num : list) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }
}
