/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8
 * Difficulty level : Easy
 */

package ExternalSources.Recursion;

import java.util.Stack;

public class DeleteTheMiddleElementOfAStack {

    public static void main(String[] args) {

        Stack<Integer> nums = new Stack<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(5);

        // middle element is defined as k = (nums.size() + 1)/2 from top
        int k = (nums.size() + 1)/2;

        System.out.println(nums);
        removeMid(nums, k, 1);
        System.out.println(nums);

    }

    private static void removeMid(Stack<Integer> nums, int k, int start) {

        if(start == k) {
            nums.pop();
            return;
        }

        int curr = nums.pop();
        removeMid(nums, k, start + 1);
        nums.push(curr);
    }

}
