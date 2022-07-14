// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1/?category
package leetcode.Greedy;

import java.util.Arrays;

public class Problem_JobSequencingProblem {
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);

        int deadline = 0;
        for(Job a : arr) deadline = Math.max(deadline, a.deadline);


        int totalProfit = 0, numJobs = 0;
        boolean[] flag = new boolean[deadline + 1];
        for(int i = 0; i < n; i++) {
            int index = findIndex(flag, arr[i].deadline);
            if(index != -1) {
                numJobs++;
                totalProfit += arr[i].profit;
                flag[index] = true;
            }
        }

        return new int[]{numJobs, totalProfit};
    }

    private int findIndex(boolean[] flag, int val) {
        for(int i = val; i > 0; i--) {
            if(!flag[i]) return i;
        }
        return -1;
    }

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
