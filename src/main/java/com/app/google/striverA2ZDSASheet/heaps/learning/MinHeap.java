package com.app.google.striverA2ZDSASheet.heaps.learning;

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int capacity;
    private int size;

    public MinHeap(int capacity) {
        if (capacity <= 0) {
            System.out.println("Capacity should be greater than 0.");
            return;
        }
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int[] newHeap = new int[this.capacity];

        System.arraycopy(heap, 0, newHeap, 0, this.heap.length);

        this.heap = newHeap;
    }

    private void swap(int index1, int index2) {
        int temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
    }

    private int parentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private int leftChildIndex(int rootIndex) {
        return (2 * rootIndex) + 1;
    }

    private int rightChildIndex(int rootIndex) {
        return (2 * rootIndex) + 2;
    }

    public void insertElement(int element) {

        if (this.size == this.capacity) {
            resize();
        }

        int insertIndex = size;

        this.heap[size++] = element;

        while (insertIndex != 0 && this.heap[insertIndex] < this.heap[parentIndex(insertIndex)]) {
            swap(insertIndex, parentIndex(insertIndex));
            insertIndex = parentIndex(insertIndex);
        }
    }

    public void decreaseElement(int index, int newSmallElement) {
        this.heap[index] = newSmallElement;

        while (index != 0 && this.heap[index] < this.heap[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public void increaseElement(int index, int newGreaterElement) {
        this.heap[index] = newGreaterElement;
        minHeapify(index);
    }

    public void changeValueOnKey(int index, int newElement) {

        if (this.heap[index] == newElement) {
            return;
        }

        if (this.heap[index] < newElement) {
            increaseElement(index, newElement);
        } else {
            decreaseElement(index, newElement);
        }
    }

    public int getMin() {
        return this.heap[0];
    }

    public int extractMin() {
        if (this.size <= 0) {
            return -1;
        }

        if (this.size == 1) {
            return this.heap[--size];
        }

        int element = this.heap[0];

        this.heap[0] = this.heap[--size];

        minHeapify(0);

        return element;
    }

    public void deleteElement(int index) {
        if (index >= size) {
            System.out.println("Given index out of size");
            return;
        }

        decreaseElement(index, Integer.MIN_VALUE);
        extractMin();
    }

    private void minHeapify(int index) {

        int smallest = index;
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (leftChildIndex < this.size && this.heap[leftChildIndex] < this.heap[smallest]) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < this.size && this.heap[rightChildIndex] < this.heap[smallest]) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(11);

        minHeap.insertElement(3);
        minHeap.insertElement(2);
        minHeap.deleteElement(1);
        minHeap.insertElement(15);
        minHeap.insertElement(5);
        minHeap.insertElement(4);
        minHeap.insertElement(45);

        System.out.print(minHeap.extractMin() + " ");
        System.out.print(minHeap.getMin() + " ");

        minHeap.decreaseElement(2, 1);

        System.out.print(minHeap.getMin());
    }
}
