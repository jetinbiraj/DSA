package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.*;

public class AccountMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );

        AccountMerge obj = new AccountMerge();
        System.out.println(obj.accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        Map<String, Integer> mapMailNode = new HashMap<>();
        DisjointSetBySize ds = new DisjointSetBySize(n);

        for (int i = 0; i < n; i++) {

            List<String> currentList = accounts.get(i);
            int currentSize = currentList.size();

            for (int j = 1; j < currentSize; j++) {

                if (!mapMailNode.containsKey(currentList.get(j))) {
                    mapMailNode.put(currentList.get(j), i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(currentList.get(j)));
                }
            }
        }

        List<String>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (var entry : mapMailNode.entrySet()) {
            lists[ds.findUltimateParent(entry.getValue())].add(entry.getKey());
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        int index = 0;
        for (List<String> list : lists) {
            if (list.isEmpty()) {
                index++;
                continue;
            }

            Collections.sort(list);
            list.addFirst(accounts.get(index++).getFirst());
            mergedAccounts.add(list);
        }

        return mergedAccounts;
    }
}
