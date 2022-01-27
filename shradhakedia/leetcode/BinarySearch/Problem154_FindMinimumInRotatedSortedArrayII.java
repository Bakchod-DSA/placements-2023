package leetcode.BinarySearch;

public class Problem154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return numberOfRotation(nums);
    }

    private int numberOfRotation(int[] nums) {
        /* Approach: Binary Search
           Time Complexity: O(n) in worst case, O(log n) in best case(when all unique elements)
           Space Complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // if all three indexes are equal go on the unsorted part
                int flag = -1;
                for(int i = low; i < mid; i++) {
                    // check if left part is unsorted
                    if(nums[i] > nums[i + 1]) {
                        flag = 0;
                        break;
                    }
                }
                for(int i = mid; i < high; i++) {
                    // left part was unsorted, this makes sure right part is sorted
                    if(flag == 0) {
                        break;
                    }
                    // check if right part is unsorted.
                    if(nums[i] > nums[i + 1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    // go to left part as it was unsorted
                    high = mid;
                } else if(flag == 1) {
                    // go to right part as it was unsorted
                    low = mid + 1;
                } else {
                    // return the lowest element as the whole array consisted of equal elements (since, flag remained unset),
                    // so minimum/(first mininium, rest are also equal but index matters when we talk about no. of rotations)
                    // was the one at the index -> low.
                    return nums[low];
                }
            }

            // we go same way, as we do in normal case
            else if(nums[mid] <= nums[high]) {
                high = mid;
            } else { // nums[mid] > nums[high]
                low = mid + 1;
            }
        }
        return nums[high];
    }
}
