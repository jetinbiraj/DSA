package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class SetUnsetBit {

    public static void main(String[] args) {
        int n = 6;

        System.out.println(setBit(n));
    }

    private static int setBit(int n) {
        return n | (n + 1);
    }
}
