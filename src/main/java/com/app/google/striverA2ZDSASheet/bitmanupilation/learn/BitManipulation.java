package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class BitManipulation {

    public static void main(String[] args) {

        int num = 13;
        int i = 2;

        bruteForceBitManipulation(num, i);
        optimalBitManipulation(num, i);
        toggleIthBit(num, i);
        clearLastSetBit(num);
        isPowerOfTwo(31);
        numberOfSetBits(4);
        oddEven(12);
        setRightMostUnsetBit(13);
    }

    private static void oddEven(int num) {

        if ((num & 1) != 0) {
            System.out.println(num + " is odd");
        } else {
            System.out.println(num + " is even");
        }
    }

    private static void numberOfSetBits(int num) {

        int count = 0;

        while (num != 0) {

            num &= (num - 1);
            count++;
        }

//        while (num != 0) {
//
//            count += num & 1;
//
//            num >>= 1;
//        }

        System.out.println("Total number of set bits are: " + count);
    }

    private static void isPowerOfTwo(int num) {
        if ((num & (num - 1)) == 0) {
            System.out.println(num + " number is power of 2");
        } else {
            System.out.println(num + " number is not power of 2");
        }
    }

    private static void setRightMostUnsetBit(int num){

        num = num | (num+1);

        System.out.println(num);
    }

    private static void clearLastSetBit(int num) {  // 1 0 1 0

        num = num & (num - 1);

        System.out.println(num);
    }

    private static void toggleIthBit(int num, int i) {


        num ^= (1 << i);

//        if ((num & (1 << i)) != 0) {
//            num &= ~(1 << i);
//        } else {
//            num |= (1<<i);
//        }


        System.out.println(num);
    }

    private static void optimalBitManipulation(int num, int i) {

        i = i - 1;

        if ((num & (1 << i)) != 0) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }

        System.out.print((num | (1 << i)) + " ");

        System.out.println((num & (~(1 << i))));
    }

    private static void bruteForceBitManipulation(int num, int i) {

        StringBuilder bs = getNumToBinaryString(num);
        i = bs.length() - i;

        if (i >= bs.length()) {
            return;
        }

        System.out.print(bs.charAt(i));

        bs.setCharAt(i, '1');
        System.out.print(" " + getBinaryStringToInteger(bs));

        bs.setCharAt(i, '0');
        System.out.print(" " + getBinaryStringToInteger(bs));
        System.out.println();
    }

    private static StringBuilder getNumToBinaryString(int num) {

        StringBuilder bs = new StringBuilder();

        while (num != 0) {

            if (num % 2 == 0) {
                bs.insert(0, '0');
            } else {
                bs.insert(0, '1');
            }

            num /= 2;
        }

        int len = bs.length();

        for (int i = 1; i <= 32 - len; i++) {
            bs.insert(0, '0');
        }

        return bs;
    }

    private static int getBinaryStringToInteger(StringBuilder bs) {

        int num = 0;
        int pow = 1;

        int len = bs.length();

        for (int i = len - 1; i >= 0; i--) {

            if (bs.charAt(i) != '0') {
                num += pow;
            }
            pow *= 2;

        }

        return num;
    }
}
