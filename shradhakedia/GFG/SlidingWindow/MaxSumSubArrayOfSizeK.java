/**
 * Author : Sradha Kedia
 * Link   : https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 * Difficulty level : Easy
 */


package GFG.SlidingWindow;

import java.util.*;

public class MaxSumSubArrayOfSizeK {

    static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0, j = 0; j < N; j++) {
            sum += Arr.get(j);
            if(j - i + 1 == K) {
                max = Math.max(max, sum);
                sum -= Arr.get(i);
                i++;
            }
        }
        return max;
    }
}
