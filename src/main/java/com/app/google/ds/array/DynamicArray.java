package com.app.google.ds.array;

/**
 * <a href="https://www.geeksforgeeks.org/how-do-dynamic-arrays-work/">...</a>
 */
public class DynamicArray {

    private int[] arr;
    private int size;
    private int count;

    public DynamicArray() {
        arr = new int[1];
        size = arr.length;
        count = 0;
    }

    private void add(int element) {

        if (size == count) {
            growSize();
        }

        arr[count++] = element;
    }

    private void growSize() {

        int[] temp = new int[size * 2];

        if (size >= 0) System.arraycopy(arr, 0, temp, 0, size);

//        for (int i = 0; i < size; i++) {
//            temp[i] = arr[i];
//        }

        arr = temp;
        size = arr.length;
    }

    private void shrinkSize() {
        int[] temp = null;

        if (count > 0) {
            temp = new int[count];

            if (size > 0) System.arraycopy(arr, 0, temp, 0, count);

            arr = temp;
            size = arr.length;

        }

    }

    private void addAt(int index, int element) {  //{2, 11, 5, 10, 7, 8, 0 , 0}

        if (count == size) {
            growSize();
        }
//5,3
        for (int i = count - 1; i >= index; i--) {

            arr[i + 1] = arr[i];
        }

        arr[index] = element;
        count++;
    }

    private void remove() {

        if (count > 0) {
            arr[--count] = 0;
        }
    }

    private void removeAt(int index) { //{2, 11, 5, 10, 7, 8}

        if (count > 0) {

            for (int i = index; i < count; i++) {

                arr[i] = arr[i + 1];

            }

            count--;
        }

    }


    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();

        // add 9 elements in array
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        da.add(6);
        da.add(7);
        da.add(8);
        da.add(9);

        // print all array elements after add 9 elements
        System.out.println("Elements of array:");
        for (int i = 0; i < da.size; i++) {
            System.out.print(da.arr[i] + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: "
                + da.count);

        // shrinkSize of array
        da.shrinkSize();

        // print all array elements
        System.out.println("Elements of array "
                + "after shrinkSize of array:");
        for (int i = 0; i < da.size; i++) {
            System.out.print(da.arr[i] + " ");
        }
        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: "
                + da.count);


        // add an element at index 1
        da.addAt(1, 22);

        // print Elements of array after adding an
        // element at index 1
        System.out.println("Elements of array after"
                + " add an element at index 1:");
        for (int i = 0; i < da.size; i++) {
            System.out.print(da.arr[i] + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: "
                + da.count);

// delete last element
        da.remove();

        // print Elements of array after delete last
        // element
        System.out.println("Elements of array after"
                + " delete last element:");
        for (int i = 0; i < da.size; i++) {
            System.out.print(da.arr[i] + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: "
                + da.count);


        // delete element at index 1
        da.removeAt(1);

        // print Elements of array after delete
        // an element index 1
        System.out.println("Elements of array after"
                + " delete element at index 1:");
        for (int i = 0; i < da.size; i++) {
            System.out.print(da.arr[i] + " ");
        }
        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: "
                + da.count);


    }
}
