package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class Conversion {

    public static void main(String[] args) {

        int num = 12;

//        System.out.println(apiIntToBinary(num));

        String binaryString = convertIntToBinaryString(num);
        int convertedInt = convertBinaryStringToInt(binaryString);
        System.out.println(num + " converted to binary: " + binaryString);
        System.out.println(binaryString + " converted to integer: " + convertedInt);
    }

    private static int convertBinaryStringToInt(String str) {

        int len = str.length();
        int num = 0;
        int pow = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) != '0') {
                num += pow;
            }
            pow *= 2;
        }

        return num;
    }

    private static String convertIntToBinaryString(int num) {

        StringBuilder res = new StringBuilder();

        while (num != 0) {

            if (num % 2 == 0) {
                res.insert(0, '0');
            } else {
                res.insert(0, '1');
            }

            num /= 2;
        }

        return res.toString();
    }

    private static String apiIntToBinary(int num) {
        return Integer.toBinaryString(num);
    }
}
