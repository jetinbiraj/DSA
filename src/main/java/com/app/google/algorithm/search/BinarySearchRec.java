package com.app.google.algorithm.search;

public class BinarySearchRec {

    private int binarySearch(int[] arr, int target, int low, int high) {

        if (low <= high) {

            int middle = (low + high) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (target < arr[middle]) {
                return binarySearch(arr, target, low, middle - 1);
            } else {
                return binarySearch(arr, target, middle + 1, high);
            }
        }

        return -1;
    }



    public static void main(String[] args) {

        BinarySearchRec ob = new BinarySearchRec();
        int[] array = {3, 4, 5, 6, 7, 8, 9};
        int n = array.length;
        int x = 9;
        int result = ob.binarySearch(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
