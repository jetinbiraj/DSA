package com.app.google.striverA2ZDSASheet.bs.answers;

public class ShipWithinDays {

    public static void main(String[] args) {

//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights = {1, 2, 3, 1, 1};
//        int days = 5;
        int days = 4;

        System.out.println(bruteForceShipWithinDays(weights, days));
        System.out.println(optimalShipWithinDays(weights, days));

    }

    private static int optimalShipWithinDays(int[] weights, int days) {

        int leastWeight = 0;
        int maxWeight = 0;
        int midWeight;

        for (int weight : weights) {
            leastWeight = Math.max(leastWeight, weight);
            maxWeight += weight;
        }

        while (leastWeight <= maxWeight) {

            midWeight = (leastWeight + maxWeight) / 2;

            int weightTracker = 0;
            int currentDays = 0;

            for (int weight : weights) {

                if (weight + weightTracker <= midWeight) {
                    weightTracker += weight;
                } else {
                    weightTracker = weight;
                    currentDays++;
                }

                if (currentDays > days) {
                    break;
                }
            }

            currentDays++;

            if (currentDays > days) {
                leastWeight = midWeight + 1;
            } else {
                maxWeight = midWeight - 1;
            }
        }

        return leastWeight;
    }


    private static int bruteForceShipWithinDays(int[] weights, int days) {

        int totalWeight = 0;

        for (int weight : weights) {
            totalWeight += weight;
        }

        for (int currentWeight = 1; currentWeight <= totalWeight; currentWeight++) {

            int currentDays = 0;
            int weightTracker = 0;
            boolean isInvalid = false;

            for (int weight : weights) {

                if (weight > currentWeight) {
                    isInvalid = true;
                    break;
                }

                if (weightTracker + weight <= currentWeight) {
                    weightTracker += weight;
                } else {
                    weightTracker = weight;
                    currentDays++;
                }

                if (currentDays > days) {
                    isInvalid = true;
                    break;
                }
            }

            currentDays++;

            if (!isInvalid && currentDays <= days) {
                return currentWeight;
            }
        }

        return -1;
    }
}
