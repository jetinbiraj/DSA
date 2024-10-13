package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class KthBitSet {

    public static void main(String[] args) {

        int num = 70;
        int k = 3;

        bruteForceKthBitSet(num, k);
        optimalKthBitSet(num, k);
    }

    public static void optimalKthBitSet(int num, int k) {

        k = k - 1;

        if ((num & (1 << k)) != 0) {
            System.out.println(k + " position bit is set");
        } else {
            System.out.println(k + " position bit is not set...");
        }

        if (((num >> k) & 1) != 0) {
            System.out.println(k + " position bit is set");
        } else {
            System.out.println(k + " position bit is not set...");
        }
    }

    public static void bruteForceKthBitSet(int num, int k) {

        StringBuilder bs = convertIntToBinaryString(num);

        if (bs.charAt(bs.length() - k - 1) == '1') {
            System.out.println(k + " position bit is set");
        } else {
            System.out.println(k + " position bit is not set...");
        }
    }

    private static StringBuilder convertIntToBinaryString(int num) {

        StringBuilder bs = new StringBuilder();

        while (num != 0) {

            if (num % 2 == 0) {
                bs.insert(0, '0');
            } else {
                bs.insert(0, '1');
            }

            num /= 2;
        }

        return bs;
    }
}
