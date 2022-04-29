/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=MOGBRkkOhkY&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=7
 * Difficulty level : Easy
 */

package ExternalSources.Recursion;

import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();
        nums.push(6);
        nums.push(2);
        nums.push(4);
        nums.push(1);
        nums.push(8);
        nums.push(3);

        System.out.println(nums);
        sorting(nums, nums.size(), 0);
        System.out.println(nums);
    }

    private static void sorting(Stack<Integer> nums, int size, int start) {
        // sorting in increasing order i.e. stack top has maximum, bottom has minimum.

        if(start == size - 1) {
            return;
        }


        int curr = nums.pop();
        sorting(nums, size,start + 1);

        Stack<Integer> temp = new Stack<>();
        while(!nums.isEmpty() && curr < nums.peek()) {
            temp.push(nums.pop());
        }

        nums.push(curr);
        while (!temp.isEmpty()) {
            nums.push(temp.pop());
        }
    }
}
