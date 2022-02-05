/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/predict-the-winner/
 * Difficulty level: Medium
 */

package leetcode.Recursion;

public class Problem486_PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return approachOne(nums);
    }

    private boolean approachOne(int[] nums) {
        /*  Approach: Recursion + BruteForce
            Time complexity : O(2^n + n)
            Space complexity : O(n)
        */

        int totalScore = findTotalScore(nums);
        int scoreOfPlayer1 = predictScoreOfPlayer1(nums, 0, nums.length - 1);
        int scoreOfPlayer2 = totalScore - scoreOfPlayer1;

        return (scoreOfPlayer1 >= scoreOfPlayer2);

    }

    private int predictScoreOfPlayer1(int[] nums, int start, int end) {

        if(start < 0 || end > nums.length - 1 || start > end) {
            // negative base case
            return 0;
        }
        if(start == end) {
            // positive base case
            return nums[start];
        }

        int recurScore1 = nums[start] + Math.min(predictScoreOfPlayer1(nums, start + 2, end), predictScoreOfPlayer1(nums, start + 1, end - 1));
        int recurScore2 = nums[end] + Math.min(predictScoreOfPlayer1(nums, start + 1, end - 1), predictScoreOfPlayer1(nums, start, end - 2));

        return Math.max(recurScore1, recurScore2);
    }

    private int findTotalScore(int[] nums) {

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return sum;
    }

}
