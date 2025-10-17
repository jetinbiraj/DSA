package com.app.google.striverA2ZDSASheet.string.hard;

import java.math.BigInteger;

public class RabinKarp {

    public static void main(String[] args) {

        String a = "abcd", b = "cdabcdab";

        RabinKarp obj = new RabinKarp();
        System.out.println(obj.repeatedStringMatchUsingAdHoc(a, b));
        System.out.println(obj.repeatedStringMatchUsingRabinKarp(a, b));
    }

    private int repeatedStringMatchUsingRabinKarp(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0;
        power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) return q;
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }

    private boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int repeatedStringMatchUsingAdHoc(String a, String b) {
        int q = 1;

        StringBuilder sb = new StringBuilder(a);

        while (sb.length() < b.length()) {
            sb.append(a);
            q++;
        }

        if (sb.indexOf(b) >= 0) {
            return q;
        }

        if (sb.append(a).indexOf(b) >= 0) {
            return q + 1;
        }

        return -1;
    }
}
