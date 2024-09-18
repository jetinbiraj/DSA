package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static void main(String[] args) {

        String num = "232";
        int target = 8;

        System.out.println(addOperators(num, target));
    }

    private static List<String> addOperators(String num, int target) {

        List<String> res = new ArrayList<>();

        addOperators(res, new StringBuilder(), num, target, 0, 0, 0);

        return res;
    }

    private static void addOperators(List<String> res, StringBuilder path, String num, int target, int pos, long calc,
                                     long mult) {

        if (pos == num.length()) {

            if (calc == target) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {

            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }

            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();

            if (pos == 0) {

                addOperators(res, path.append(cur), num, target, i + 1, cur, cur);
                path.setLength(len);

            } else {

                addOperators(res, path.append("+").append(cur), num, target, i + 1, calc + cur, cur);
                path.setLength(len);

                addOperators(res, path.append("-").append(cur), num, target, i + 1, calc - cur, -cur);
                path.setLength(len);

                addOperators(res, path.append("*").append(cur), num, target, i + 1, calc - mult + mult * cur,
                        mult * cur);
                path.setLength(len);
            }
        }
    }
}
