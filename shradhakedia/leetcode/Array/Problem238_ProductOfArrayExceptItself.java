/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/product-of-array-except-self/
 * Difficulty level: Medium
 */
package leetcode.Array;

public class Problem238_ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        return approachTwo(nums);
    }

    private int[] approachOne(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] postfixProd = new int[n];
        prefixProd[0] = 1;
        postfixProd[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            postfixProd[i] = postfixProd[i + 1] * nums[i + 1];
        }

        int[] prod = new int[n];
        for(int i = 0; i < n; i++) {
            prod[i] = prefixProd[i] * postfixProd[i];
        }
        return prod;
    }

    private int[] approachTwo(int[] nums) {
        // constant space
        int n = nums.length;
        int[] prod = new int[n];

        prod[0] = 1;
        for(int i = 1; i < n; i++) {
            prod[i] = prod[i - 1] * nums[i - 1];
        }

        int rightProd = 1;
        for(int i = n - 1; i >= 0; i--) {
            prod[i] *= rightProd;
            rightProd *= nums[i];
        }

        return prod;
    }
}
