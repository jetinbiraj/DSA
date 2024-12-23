package com.app.google.striverA2ZDSASheet.bst.concept;

public class ValidBST {

    public static void main(String[] args) {

        int[] arr = {8, 14, 45, 64, 100};
        System.out.println(isBSTTraversal(arr));
    }

    private static boolean isBSTTraversal(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i + 1] <= arr[i]) {
                return false;
            }
        }

        return true;
    }
}
