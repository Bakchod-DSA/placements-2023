package LeetCode.pointers;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/rotate-array/
 * Difficulty level : Medium
 */
public class problem189RotateArray {
    public void rotate(int[] nums, int k) {
        // approachTwo(nums, k);
        approachThree(nums, k);
    }

    /**
     Time : O(N)
     Space : constant
     Algo : Reverse the whole array, reverse the half array from start to k - 1 index,
     reverse the remaining array again
     e.g. nums = [1,2,3,4,5,6,7] k = 4
     step 1 : [7,6,5,4,3,2,1]
     step 2 : [4,5,6,7,3,2,1]
     step 3 : [4,5,6,7,1,2,3]
     */
    private void approachThree(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     take two pointers at start and end of the subarray which we want to reverse
     swap those elements, update start and end index
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     Tiem : O(N)
     space : constant
     Algo : ptr1 = start index
     ptr2 = kth index
     pos = to avoid loop e.g. if nums = [1,2,3,4] and k = 2
     it will keep looping for same two elements, everytime we detect a loop
     (index that we have already explored) we increment our pos and fix our ptr1 and ptr2 accordingly
     temp2 = ele at ptr2
     temp1 = ele at ptr1

     We save ptr2 index element and place ptr1 index element at ptr2 index,
     make ptr1 as ptr2 and ptr2 as (k + ptr2) % n, we keep doing it till we found loop,
     at this moment we increment our pos and make ptr1 equal to new pos and modify ptr2 accordingly
     (Important to remember, when we change pos index,
     we should also update temp1 variable as its still storing prevoius pos index element)
     */
    private void approachTwo(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        int temp1 = nums[0];
        int temp2;
        int pos = 0;
        int ptr1 = 0;
        int ptr2 = (ptr1 + k)%n;

        while (count < n) {

            temp2 = nums[ptr2];
            nums[ptr2] = temp1;
            temp1 = temp2;
            ptr1 = ptr2;
            ptr2 = (ptr1 + k)%n;
            count++;
            if (pos == ptr1) {
                pos++;
                if (pos == n) break;
                temp1 = nums[pos];
                ptr1 = pos;
                ptr2 = (ptr1+ k)%n;
            }
        }

    }

    /**
     Time : O(N^2)
     Space : constant

     save the kth index element in a temperory variable
     shift the elements from start pointer to kth index
     put the temperory saved element at start index
     increment both start and kth index pointer

     eg [1,2,3,4,5] k = 3
     step 1 : here, ele 4 will be temp  [4,1,2,3,5]
     step 2 : here, ele 5 will be temp [5,4,1,2,3]
     */
    private void approachOne(int[] nums, int k){
        int n = nums.length;
        int p1 = 0;
        int p2 = n - (k%n);
        while (p2 < n) {
            int temp = nums[p2];
            for (int i = p2; i > p1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[p1] = temp;
            p1++;
            p2++;
        }
    }
}
