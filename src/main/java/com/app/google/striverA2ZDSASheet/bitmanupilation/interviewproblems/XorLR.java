package com.app.google.striverA2ZDSASheet.bitmanupilation.interviewproblems;

public class XorLR {

    public static void main(String[] args) {

        int l = 5;
        int r = 12;

        System.out.println(bruteForceFindXOR(l, r));
        System.out.println(optimalFindXOR(l, r));
    }

    private static int optimalFindXOR(int l, int r) {
        return findXOR(l - 1) ^ findXOR(r);
    }

    private static int findXOR(int num) {

        int rem = num % 4;

        if (rem == 1) {
            return 1;
        } else if (rem == 2) {
            return num + 1;
        } else if (rem == 3) {
            return 0;
        } else {
            return num;
        }
    }

    private static int bruteForceFindXOR(int l, int r) {
        int xor = l;

        for (int i = l + 1; i <= r; i++) {
            xor ^= i;
        }

        return xor;
    }
}
