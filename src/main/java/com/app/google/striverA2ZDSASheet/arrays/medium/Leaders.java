package com.app.google.striverA2ZDSASheet.arrays.medium;

public class Leaders {

    public static void main(String[] args) {

        int[] arr = {10, 22, 12, 3, 0, 6};

        optimalLeaders(arr);
    }

    private static void optimalLeaders(int[] arr){

        int max = Integer.MIN_VALUE;

        for(int i=arr.length-1; i>=0; i--){

            if(arr[i] > max){
                max = arr[i];
                System.out.print(max + " ");
            }
        }

    }
}
