package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetBySize {

    public final List<Integer> size, parent;

    public DisjointSetBySize(int n) {
        this.size = new ArrayList<>();
        this.parent = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int uUltimateParent = findUltimateParent(u);
        int vUltimateParent = findUltimateParent(v);

        if (uUltimateParent == vUltimateParent) {
            return;
        }

        if (size.get(uUltimateParent) < size.get(vUltimateParent)) {
            parent.set(uUltimateParent, vUltimateParent);
            size.set(vUltimateParent, size.get(vUltimateParent) + size.get(uUltimateParent));
        } else {
            parent.set(vUltimateParent, uUltimateParent);
            size.set(uUltimateParent, size.get(uUltimateParent) + size.get(vUltimateParent));
        }
    }

    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

        ds.unionBySize(3, 7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}
