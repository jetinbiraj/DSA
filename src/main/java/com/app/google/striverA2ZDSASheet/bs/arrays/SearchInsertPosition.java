package com.app.google.striverA2ZDSASheet.bs.arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = {1,2,4,7};
        System.out.println(bruteForceSearchInsert(nums, 6));
        System.out.println(optimalSearchInsert(nums, 6));
    }

    private static int optimalSearchInsert(int[] nums, int target) {

        int insertIndex = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high){

            mid = (low + high)/2;

            if(nums[mid]>=target){
                insertIndex = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return insertIndex;
    }


    private static int bruteForceSearchInsert(int[] nums, int target) {

        for(int i=0; i<nums.length; i++){

            if(nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}
