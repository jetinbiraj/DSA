package com.app.google.striverA2ZDSASheet.heaps.learning;

import java.util.Arrays;

public class MinToMaxHeap {

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 11, 13};
        convertMinToMaxHeap(arr.length, arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void maxHeapify(int n, int[] arr, int index) {

        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;

        int largest = index;

        if (leftChildIndex < n && arr[largest] < arr[leftChildIndex]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < n && arr[largest] < arr[rightChildIndex]) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(n, arr, largest);
        }
    }

    static void convertMinToMaxHeap(int n, int arr[]) {

        for (int i = (n - 2) / 2; i >= 0; i--) {

            maxHeapify(n, arr, i);
        }
    }
}
