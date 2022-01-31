/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-the-duplicate-number/
 * Difficulty level : Medium
 * Discuss (Must Read!) : https://leetcode.com/problems/find-the-duplicate-number/solution/
 */

package leetcode.BinarySearch;

public class Problem287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        return approachFive(nums);

    }

    private int approachOne(int[] nums) {
    /*  Approach 1: Negative Marking
        Time Complexity: O(n)
        Space Complexity: O(1)
    */

        for(int i = 0; i <  nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index] < 0) {
                return index;
            } else {
                nums[index] *= -1;
            }
        }
        return -1; // if no duplicate
    }

    private int approachTwo(int[] nums) {
    /*  Approach 2: Array as HashMap (Iterative)
        Time Complexity: O(n)
        Space Complexity: O(1)
    */

        while(nums[0] != nums[nums[0]]) {
            swap(nums, 0, nums[0]);
        }
        return nums[0];
    }

    private int approachThree(int[] nums) {
    /*  Approach 3: Array as HashMap (Recursive)
        Time Complexity: O(n)
        Space Complexity: O(1)
    */

        if(nums[0] == nums[nums[0]]) {
            return nums[0];
        }
        swap(nums, 0, nums[0]);
        return approachThree(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int approachFour(int[] nums) {
    /*  Approach 4: Binary Search
        Time Complexity: O(nlog(n))
        Space Complexity: O(1)
        Intuition: To run binary search on the range [1,n] and check for the nos. where the count of nos. <= no.
                   is more than it, if we get count more go to left part else go to the right part.
                   It typically follows pigeon hole principle, eg. [2,1,2,2,2,2,2] BS on [1, 6]. mid = 3
                   7 nos. less than or equal to 3 implies duplicate in between [1,3]. now, mid = 2 again 7 nos. less than
                   or equal to 2 implies duplicate in between [1,2]. now, mid = 1, 1 no. less than 1.
                   so, it implies duplicate in between [2,2]. Loop terminates, 2 is the answer.
    */

        int low = 1;
        int high = nums.length - 1; // h = n and elements in nums are in range [1,n]

        while(low < high) {
            int mid = low + ((high - low) >> 1);

            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }

            if(count <= mid) {
                low = mid + 1;
            } else { // count > mid
                high = mid;
            }
        }

        return high;
    }

    private int approachFive(int[] nums) {
    /*  Approach 4: Bit Manipulation
        Time Complexity: O(m * n), where m is length of bits in n, considering m as log n, O(n * log(n))
        Space Complexity: O(1)
        Intuition: Solution page
    */
        int msb = findMsbOfANumber(nums.length - 1); // O(log (30) in worst i.e. 5 can be treated as O(1))
        int duplicate = 0;

        for(int bit = 0; bit <= msb; bit++) {
            // O(m * n)
            int baseCount = 0, numsCount = 0;
            int mask = 1 << bit;

            for(int i = 0; i < nums.length; i++) {
                if((i & mask) == mask) {
                    baseCount++;
                }

                if((nums[i] & mask) == mask) {
                    numsCount++;
                }
            }

            if((numsCount - baseCount) > 0) {
                duplicate |= mask;
            }
        }
        return duplicate;
    }

    private int findMsbOfANumber(int target) {
        int low = 0;
        int high = 30;

        while(low < high) {
            int mid = high - ((high - low) >> 1);
            if((1 << mid) <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int approachSix(int[] nums) {
        /*  Approach: Floyd's Tortoise and Hare (Cycle Detection)
            Time Complexity: O(n)
            Space Complexity: O(1)
            Intuition: We keep two pointers, slow(tortoise) and fast(hare) and move slow one step at a time.
                       Move fast two steps at a time, if no cycle hare wins the race by reaching null. else if there is
                       a cycle hare enters it first, keeps on revolving it.
                       tortoise enters it later but the hare catches the tortoise at a certain point in the cycle
                       (this is the meeting/intersection point is which may not be the entry point of cycle) so, we give
                       tortoise another chance by setting to first node again and move hare also one step now.
                       and now as they meet it is guaranteed to be the entry point of the cycle. Its a famous problem of
                       cycle detection in Linked List(Floyd's Tortoise and Hare, Cycle Detection).
        */

        int tortoise = nums[0], hare = nums[0];

        // Find the intersection point of the two runners.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return tortoise;
    }

}
