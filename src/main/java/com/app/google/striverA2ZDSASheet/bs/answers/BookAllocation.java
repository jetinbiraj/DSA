package com.app.google.striverA2ZDSASheet.bs.answers;

import java.util.Arrays;
import java.util.List;

public class BookAllocation {

    public static void main(String[] args) {
        List<Integer> booksWithPages = Arrays.asList(12, 34, 67, 90);
        int m = 2;
        int n = 4;

        System.out.println(bruteForceAllocateBooks(booksWithPages, n, m));
        System.out.println(optimalAllocateBooks(booksWithPages, n, m));
    }

    private static int optimalAllocateBooks(List<Integer> arr, int n, int m) {

        if (m > n) {
            return -1;
        }

        int maxPages = 0;
        int totalPages = 0;
        int mid;

        for (int pages : arr) {
            maxPages = Math.max(maxPages, pages);
            totalPages += pages;
        }

        while (maxPages <= totalPages) {
            mid = (maxPages + totalPages) / 2;

            int students = allocatePagesToStudents(arr, mid, m);

            if (students > m) {
                maxPages = mid + 1;
            } else {
                totalPages = mid - 1;
            }
        }

        return maxPages;
    }

    private static int bruteForceAllocateBooks(List<Integer> arr, int n, int m) {

        int maxMinPages = -1;
        if (m > n) {
            return -1;
        }

        int maxPages = 0;
        int totalPages = 0;

        for (int pages : arr) {
            maxPages = Math.max(maxPages, pages);
            totalPages += pages;
        }

        for (int currentPages = maxPages; currentPages <= totalPages; currentPages++) {

            if (allocatePagesToStudents(arr, currentPages, m) == m) {
                return currentPages;
            }
        }

        return maxMinPages;
    }

    private static int allocatePagesToStudents(List<Integer> arr, int currentPages, int m) {

        int students = 1;
        int assigningPages = 0;

        for (int pages : arr) {

            if (pages + assigningPages <= currentPages) {
                assigningPages += pages;
            } else {
                students++;
                assigningPages = pages;
            }

            if (students > m) {
                break;
            }
        }

        return students;
    }
}
