package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/longest-increasing-subsequence/
 * Difficulty level : Medium
 */
public class Xproblem300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // return approachOne(nums);
        return approachTwo(nums);
    }

    /**
     Bottom Up Approach
     Time  : O(N^2)
     Space : O(N)
     Algo  : Since in worst case too, min length of subsequence is one, hence initialise dp table as 1
     here DP table store LIS till index i if ith element is taken as part of subsequence
     for every element before ith element which is smaller thn ith element can contribute to LIS,
     hence we will such element whose LIS length is maximum and add current element to it.
     e.g. nums = [3, 4, -1, 0, 6, 2, 3]
     dp = [1, 2,  1, 2, 3, 3, 4] -> max len subsequence will be of length 4 which is [-1, 0, 2, 3]
     */
    public int approachOne(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i]+= max;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     Dynamic Programming + Binary Search
     Time  : O(NlogN)
     Space : O(N)
     Algo  : We are maintaining DP table whose each index stores last element of LIS of length equal to index

     If we are having next element greater than last element of DP, that means it surely increases length
     of LIS hence will be added at the last

     if we are having element smaller thn last element of DP, that means there will be an element which can be                 replaced by current element for sure ->
     Reason : It always better to store 1, 4, 6 instead of 1, 4, 8 as we might have 7 as next element and can
     contribute to LIS
     */
    public int approachTwo(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(dp, nums[i]);
            if (idx == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(idx, nums[i]);
            }
        }
        return dp.size();
    }

    private int binarySearch(ArrayList<Integer> dp, int ele) {

        int idx = -1;
        int l = 0;
        int h = dp.size() - 1;

        while (l <= h) {

            int m = l + ((h - l) >> 1);

            if (dp.get(m) < ele) {
                l = m + 1;
            } else {
                idx = m;
                h = m - 1;
            }
        }
        return idx == -1 ? dp.size() : idx;
    }
}
