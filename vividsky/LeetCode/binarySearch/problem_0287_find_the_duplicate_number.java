
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-the-duplicate-number/
 * Difficulty level : Medium
 */
package LeetCode.binarySearch;

public class problem_0287_find_the_duplicate_number {
    public int findDuplicate(int[] nums) {
        return approachOne(nums);
        // return approachTwo(nums);
        // return approachThree(nums);
        // return approachFour(nums);
    }

    /*
    Floyd cycle detection algorithm
    Time complexity: O(N)
    Space Complexity : constant
    link : https://www.youtube.com/watch?v=PvrxZaH_eZ4&ab_channel=Insidecode
    we work with two pointers hare and tortoise, hare moves two times faster thn tortoise
    once they intersect, move hare back to start and move both one unit at a time,
    next time they will intersect at the start of cycle for sure.
    */
    private int approachFour(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[nums[0]];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        tortoise = 0;
        while (tortoise != hare) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return hare;
    }

    /*
    Inplace sorting
    Time Complexity : O(N) placing each ele at its correct index, takes linear iterations.
    space Complexity : constant
    */
    private int approachThree(int[] nums) {

        int i = 0;
        while (nums[i] != i) {
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int temp =  nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return -1;
    }

    /*
    Time Complexity : O(N)
    Space Complexity : constant
    modify array
    algo : whenever you get any idx, make ele at that idx as negative,
            once we get any idx which have already negative ele, return that idx
    */
    private int approachTwo(int[] nums) {
        int idx = nums[0];
        while(true) {
            if (nums[idx] > 0) {
                int temp = idx;
                idx = nums[idx];
                nums[temp] *= -1;
            } else {
                return idx;
            }
        }

    }

    /*
    Time Complexity : Nlog(N)
    Space Complexity : constant
    Algo: Once we sort the array, then for sure duplicate element will be a
            fixed ele (ele whose index is equal to its value)
            Once we get it, that is our one valid option,
            we save it and explore more indices in right
            1,2,3,4,5,5 all ele less than 5 are fixed ele,
            hence we will look for the largest ele satisfying our condition i.e. 5
    */
    private int approachOne(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == mid + 1) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < mid + 1) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return nums[ans];
    }

}
