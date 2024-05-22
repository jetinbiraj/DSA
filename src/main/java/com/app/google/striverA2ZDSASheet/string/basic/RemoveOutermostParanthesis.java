package com.app.google.striverA2ZDSASheet.string.basic;

public class RemoveOutermostParanthesis {

    public static void main(String[] args) {

        String str = "(()())(())(()(()))";

        System.out.println(removeOuterParentheses(str));

    }

    public static String removeOuterParentheses(String s) {

        int count = 0 ;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){

            if(c == '(' && ++count > 1){
                sb.append(c);
            }else if(c == ')' && --count >= 1){
                sb.append(c);
            }

        }

        // for(int i=0; i<s.length(); i++){

        //     if(s.charAt(i) == '('){
        //         count +=1;

        //         if(count > 1){
        //             sb.append(s.charAt(i));
        //         }
        //     } else if (s.charAt(i) == ')') {

        //         count -=1;

        //         if(count>=1){
        //             sb.append(s.charAt(i));
        //         }

        //     }

        // }

        return sb.toString();

    }
}
