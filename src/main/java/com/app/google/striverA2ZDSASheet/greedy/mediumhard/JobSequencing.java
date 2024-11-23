package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {

    static class Job {
        int id, profit, deadline;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        Job[] jobs = new Job[4];

        jobs[0] = new Job(1, 3, 50);
        jobs[1] = new Job(2, 1, 10);
        jobs[2] = new Job(3, 2, 20);
        jobs[3] = new Job(4, 2, 30);

        System.out.println(JobScheduling(jobs, 4));
    }

    private static ArrayList<Integer> JobScheduling(Job[] jobs, int n) {

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.profit));

        int[] hash = new int[n];
        int jobCount = 0;
        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {

            int currentDeadline = jobs[i].deadline - 1;

            if (hash[currentDeadline] == 0) {

                hash[currentDeadline] = -1;
                jobCount++;
                profit += jobs[i].profit;

            } else {

                for (int j = currentDeadline - 1; j >= 0; j--) {

                    if (hash[j] == 0) {

                        hash[j] = -1;
                        profit += jobs[i].profit;
                        jobCount++;
                        break;
                    }
                }
            }
        }

        return new ArrayList<>(List.of(jobCount, profit));
    }
}
