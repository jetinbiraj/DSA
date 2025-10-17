package com.app.google.striverA2ZDSASheet.bs.answers;

public class MedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {2, 4, 6};
        int[] nums2 = {1, 3, 5};

        System.out.println(bruteForceFindMedianSortedArrays(nums1, nums2));
        System.out.println(betterFindMedianSortedArrays(nums1, nums2));
        System.out.println(optimalFindMedianSortedArrays(nums1, nums2));
    }

    private static double optimalFindMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2) {
            return optimalFindMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;

        int left = (n + 1) / 2;
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }

            if (mid2 < n2) {
                r2 = nums2[mid2];
            }

            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {

                return (n & 1) == 1 ? Math.max(l1, l2) : (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;

            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    private static double betterFindMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int mLength = m + n;

        int midPoint1 = (mLength / 2) - 1;
        int midPoint2 = mLength / 2;
        int midPointElement1 = 0;
        int midPointElement2 = 0;

        int mPointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        boolean foundBothElements = false;

        while (pointer1 < n && pointer2 < m) {

            if (nums1[pointer1] < nums2[pointer2]) {

                if (mPointer == midPoint1) {
                    midPointElement1 = nums1[pointer1];
                }
                if (mPointer == midPoint2) {
                    midPointElement2 = nums1[pointer1];
                    foundBothElements = true;
                    break;
                }
                mPointer++;
                pointer1++;
            } else {
                if (mPointer == midPoint1) {
                    midPointElement1 = nums2[pointer2];
                }
                if (mPointer == midPoint2) {
                    midPointElement2 = nums2[pointer2];
                    foundBothElements = true;
                    break;
                }
                mPointer++;
                pointer2++;
            }
        }
        while (!foundBothElements && pointer1 < n) {
            if (mPointer == midPoint1) {
                midPointElement1 = nums1[pointer1];
            }
            if (mPointer == midPoint2) {
                midPointElement2 = nums1[pointer1];
                break;
            }
            mPointer++;
            pointer1++;
        }

        while (!foundBothElements && pointer2 < m) {
            if (mPointer == midPoint1) {
                midPointElement1 = nums2[pointer2];
            }
            if (mPointer == midPoint2) {
                midPointElement2 = nums2[pointer2];
                break;
            }
            mPointer++;
            pointer2++;
        }

        if (mLength % 2 == 1) {
            return midPointElement2;
        }

        return (double) (midPointElement1 + midPointElement2) / 2;
    }


    private static double bruteForceFindMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];
        int m = mergedArray.length;

        int pointer1 = 0;
        int pointer2 = 0;
        int mPointer = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {

            if (nums1[pointer1] < nums2[pointer2]) {
                mergedArray[mPointer++] = nums1[pointer1++];
            } else {
                mergedArray[mPointer++] = nums2[pointer2++];
            }
        }

        while (pointer1 < nums1.length) {
            mergedArray[mPointer++] = nums1[pointer1++];
        }
        while (pointer2 < nums2.length) {
            mergedArray[mPointer++] = nums2[pointer2++];
        }


        int middleIndex = m / 2;

        if (m % 2 == 0) {
            return (double) (mergedArray[middleIndex] + mergedArray[middleIndex - 1]) / 2;
        }
        return mergedArray[middleIndex];
    }
}
