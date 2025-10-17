package com.app.google.striverA2ZDSASheet.recursion.stronghold;

import java.util.Collections;
import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(11);
        s.push(101);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);
        s.push(99);

        sort(s);

        s.forEach(e -> System.out.print(e + " "));
    }

    private static void sort(Stack<Integer> s) {  //11, 101, 2, 32, 3, 41, 99 || 2 11 3 32 41 99 101

        if (!s.isEmpty()) {
            int element = s.pop();
            sort(s);
            sortedInsert(s, element);
        }
    }

    private static void sortedInsert(Stack<Integer> s, int element) {

        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
            return;
        }

        int existingElement = s.pop();

        sortedInsert(s, element);

        s.push(existingElement);
    }

    private static Stack<Integer> naiveSort(Stack<Integer> s) {
        Collections.sort(s);
        return s;
    }
}
