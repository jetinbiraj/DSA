package com.app.google.striverA2ZDSASheet.tries;

public class BitsOperations {

    public static void main(String[] args) {

        int num = 10;

        int sq = (int)Math.sqrt(num);

    }

    public int XOR(int n, int m) {
        return n ^ m;
    }

    public int check(int a, int b) {
        return b >> (a - 1) & 1;
    }

    public int setBit(int c, int d) {
        return 1 << c | d;
    }
}
