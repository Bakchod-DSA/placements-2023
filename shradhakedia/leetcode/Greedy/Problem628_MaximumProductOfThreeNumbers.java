// https://leetcode.com/problems/maximum-product-of-three-numbers/
package leetcode.Greedy;

import java.util.Arrays;

public class Problem628_MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        return approachTwo(nums);
    }

    private int approachOne(int[] nums) {
        // T.C. O(n logn)
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    private int approachTwo(int[] nums) {
        // T.C. O(n)
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2) {
                min2 = num;
            }

            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
