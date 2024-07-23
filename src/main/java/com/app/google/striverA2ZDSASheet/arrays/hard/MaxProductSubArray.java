package com.app.google.striverA2ZDSASheet.arrays.hard;

public class MaxProductSubArray {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 0};
//        int[] arr = {1,2,-3,0,-4,-5};
        int[] arr = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};

        System.out.println(bruteForceMaxProduct(arr));
        System.out.println(betterMaxProduct(arr));
        System.out.println(optimalMaxProduct(arr));
        System.out.println(optimalMaxProductKadaneAlgorithm(arr));
    }

    private static int optimalMaxProductKadaneAlgorithm(int[] arr) {

        int resultMaxProduct = arr[0];
        int maxProduct = arr[0];
        int minProduct = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if ((long) maxProduct * arr[i] > Integer.MAX_VALUE || (long) minProduct * arr[i] < Integer.MIN_VALUE) {
                continue;
            }

            int tempProduct = Math.max(arr[i], Math.max(arr[i] * maxProduct, arr[i] * minProduct));
            minProduct = Math.min(arr[i], Math.min(arr[i] * maxProduct, arr[i] * minProduct));

            maxProduct = tempProduct;

            resultMaxProduct = Math.max(maxProduct, resultMaxProduct);
        }

        return resultMaxProduct;
    }

    private static int optimalMaxProduct(int[] arr) {

        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < arr.length; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            if ((long) prefix * arr[i] > Integer.MIN_VALUE && (long) prefix * arr[i] < Integer.MAX_VALUE) {
                prefix *= arr[i];
            }

            if ((long) suffix * arr[i] > Integer.MIN_VALUE && (long) suffix * arr[i] < Integer.MAX_VALUE) {
                suffix *= arr[arr.length - 1 - i];
            }

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    private static int betterMaxProduct(int[] arr) {

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int product = arr[i];

            for (int j = i; j < arr.length; j++) {

                if ((long) product * arr[j] > Integer.MAX_VALUE || (long) product * arr[j] < Integer.MIN_VALUE) {
                    continue;
                }

                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    private static int bruteForceMaxProduct(int[] arr) {

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int product = arr[i];

            for (int j = i; j < arr.length; j++) {

                for (int k = i; k <= j; k++) {

                    if ((long) product * arr[k] > Integer.MAX_VALUE || (long) product * arr[k] < Integer.MIN_VALUE) {
                        continue;
                    }

                    product *= arr[k];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }
}
