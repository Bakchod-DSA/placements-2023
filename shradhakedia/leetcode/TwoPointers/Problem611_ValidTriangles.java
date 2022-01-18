/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/valid-triangle-number/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

import java.util.Arrays;

public class Problem611_ValidTriangles {

    public int triangleNumber(int[] nums) {

        /*
        // Approach 1: Brute Force (TLE)
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1, k = j + 1; j < nums.length && k < nums.length; ) {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                if((a + b > c) && (b + c > a) && (a + c > b)) {
                    count++;
                }
                if(k == nums.length - 1) {
                    j++;
                    k = j + 1;
                }
                else {
                    k++;
                }
            }
        }
        return count;
        */

        /*
        // Approach 2: Binary Search
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int index = binarySearch(nums, j + 1, sum);
                if(index != -1) {
                    count += (index - j);
                }
            }
        }
        return count;
        */

        // Approach 3: Two Pointers
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i >= 2; i--) {
            for(int j = 0, k = i - 1; j < k; ) {
                if(nums[j] + nums[k] > nums[i]) {
                    count+= (k - j);
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int start, int target) {
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + ((end - start) >> 1);
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if(start >= nums.length) return -1;
        if(nums[start] < target) return start;
        return start - 1;
    }
}

/**
 * Triangle Inequality states that given three sides of a triangle, the sum of any two sides is always greater than the
 * third. we need to apply this law in the problem above but we can also see that if a < b < c then (a + c) > b and
 * (b + c) > a but (a + b) > c needs to be checked so we sort our array and check sum of two smaller no. is greater then
 * the third(largest) number if so, the above law is satisfied.
 *
 * Approach 1: Brute Force; Time Complexity: O(n^3), Space Complexity: O(1)
 *             Intuition: The brute force approach gives TLE if list length is 10^3,
 *                        the code runs 10^9 times (n^3 complexity). The idea is just to take each triplet and increment
 *                        counter if they meet triangle inequality law criteria.
 * Approach 2: Binary Search; Time Complexity: O(nlog(n) + n^2.log(n)), Space Complexity: O(1)
 *             Intuition: just like 2-sum binary search approach, sort the array first then start with two loops
 *                        to get a unique pair and sum them then use binary search to find a 'k' (after ith,jth index) s.t.
 *                        the k is the biggest no. smaller than this sum (nums[i] + nums[j] > nums[k]). and now all the nos.
 *                        between j and k will follow this inequality. repeat the process for all pairs to find unique triplets.
 * Approach 3: Two Pointers; Time Complexity: O(n), Space Complexity: O(1)
 *             Intuition: sort the array and start a pointer i from end, to find j and k, we set j at 0 and k at i - 1.
 *                        now if nums[j] + nums[k] > nums[i] then we are sure all the j's till k follow this, as array is sorted.
 *                        so count += k - j and check for k--. but, if nums[j] + nums[k] < nums[i] then we can increment
 *                        j and check further.
 *             NOTE:      this won't work if we sort the array and start loop from beginning because then i = 0, j = 1, k = end
 *                        if nums[i] + nums[j] > nums[k], we know for all j till k it will be true so we do k--;
 *                        but, if nums[i] + nums[j] < nums[k], then we have two options: 1) j++, 2) k--.
 *                        so, we get stuck here that is the need we need to fix R.H.S. which is done in scenario 1.
 */