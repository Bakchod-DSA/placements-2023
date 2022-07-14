// https://practice.geeksforgeeks.org/problems/maximum-sum-of-increasing-order-elements-from-n-arrays4848/1/?category
package leetcode.Greedy;

import java.util.Arrays;

public class Problem_MaximumSumOfIncreasingOrderElementsFromNArrays {
    public static int maximumSum (int n, int m, int arr[][]) {
        // T.C. : O(nm)
        int sum = 0, nextMax = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            int currMax = -1;
            for(int j = m - 1; j >= 0; j--) {
                if(nextMax > arr[i][j]) {
                    currMax = Math.max(currMax, arr[i][j]);
                }
            }
            if(currMax == -1) return 0;
            sum += currMax;
            nextMax = currMax;
        }

        return sum;
    }


    private static int approachOne(int n, int m, int arr[][]) {
        // T.C. O(nm logm)
        for(int[] a : arr) Arrays.sort(a);

        int sum = 0, nextMax = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            int flag = 0;
            for(int j = m - 1; j >= 0; j--) {
                if(nextMax > arr[i][j]) {
                    sum += arr[i][j];
                    nextMax = arr[i][j];
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return 0;
        }

        return sum;
    }
}
