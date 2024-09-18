package com.app.google.striverA2ZDSASheet.recursion.stronghold;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

//        bruteForceReverse(stack);
        RecursiveReverse(stack);

        stack.forEach(e -> System.out.print(e + " "));
    }

    private static void RecursiveReverse(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int element = s.pop();
            RecursiveReverse(s);
            insert(s, element);
        }
    }

    private static void insert(Stack<Integer> s, int element) {

        if(s.isEmpty()) {
            s.push(element);
            return;
        }

        int existingElement = s.pop();
        insert(s, element);
        s.push(existingElement);
    }


    private static void bruteForceReverse(Stack<Integer> s){
        List<Integer> list = new ArrayList<>();

        while(!s.isEmpty()) {
            list.add(s.pop());
        }

        for(int num:list) {
            s.push(num);
        }
    }
}


