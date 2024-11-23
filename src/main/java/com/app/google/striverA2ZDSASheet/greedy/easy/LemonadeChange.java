package com.app.google.striverA2ZDSASheet.greedy.easy;

public class LemonadeChange {

    public static void main(String[] args) {

        int[] bills = {5, 5, 5, 10, 20};

        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {

        int fiveChange = 0;
        int tenChange = 0;

        for (int bill : bills) {

            if (bill == 5) {
                fiveChange++;
            } else if (bill == 10) {
                tenChange++;
                fiveChange--;
            } else if (tenChange > 0) {
                tenChange--;
                fiveChange--;

            } else {
                fiveChange -= 3;
            }

            if (fiveChange < 0) {
                return false;
            }
        }

        return true;
    }
}
