package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    private List<Integer> rank, parent;

    public DisjointSet(int n) {
        this.rank = new ArrayList<>();
        this.parent = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }

        parent.set(node, findUltimateParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int uUltimateParent = findUltimateParent(u);
        int vUltimateParent = findUltimateParent(v);

        if (uUltimateParent == vUltimateParent) {
            return;
        }

        if (rank.get(uUltimateParent) < rank.get(vUltimateParent)) {
            parent.set(uUltimateParent, vUltimateParent);
        } else if (rank.get(vUltimateParent) < rank.get(uUltimateParent)) {
            parent.set(vUltimateParent, uUltimateParent);
        } else {
            parent.set(vUltimateParent, uUltimateParent);
            rank.set(uUltimateParent, rank.get(uUltimateParent) + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)){
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

        ds.unionByRank(3,7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)){
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}
