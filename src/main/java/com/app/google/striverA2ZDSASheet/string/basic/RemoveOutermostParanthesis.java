package com.app.google.striverA2ZDSASheet.string.basic;

public class RemoveOutermostParanthesis {

    public static void main(String[] args) {

        String str = "(()())(())(()(()))";

        System.out.println(removeOuterParentheses(str));

    }

    public static String removeOuterParentheses(String s) {

        StringBuilder removedOuterParentheses = new StringBuilder();

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(' && ++count > 1) {
                removedOuterParentheses.append(ch);
            } else if (ch == ')' && --count >= 1) {
                removedOuterParentheses.append(ch);
            }

        }

        // for(int i=0; i<s.length(); i++){

        //     if(s.charAt(i) == '('){
        //         count +=1;

        //         if(count > 1){
        //             removedOuterParentheses.append(s.charAt(i));
        //         }
        //     } else if (s.charAt(i) == ')') {

        //         count -=1;

        //         if(count>=1){
        //             removedOuterParentheses.append(s.charAt(i));
        //         }

        //     }

        // }

        return removedOuterParentheses.toString();

    }
}
