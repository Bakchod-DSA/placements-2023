/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

import java.util.*;

public class Problem215_KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        // return approachOne(nums, k);
        // return approachTwo(nums, k);
        return approachThree(nums, k);
        // return approachFour(nums, k);
    }

    private int approachOne(int[] nums, int k) {
        /*  Approach: Brute Force (Sorting)
            Time Complexity: O(n log n) in average
            Space Complexity: O(1)
        */

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int approachTwo(int[] nums, int k) {
        /*  Approach: Priority Queue(min Heap)
            Time Complexity: O(n log k) in average
            Space Complexity: O(k)
        */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    private int approachThree(int[] nums, int k) {
        /*  Approach: Priority Queue(max Heap)
            Time Complexity: O(n + klog n) in average
            Space Complexity: O(k)
        */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums) {
            maxHeap.add(num);
        }

        while(k > 1) {
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
    }


    private int approachFour(int[] nums, int k) {
        /*  Approach: Quick Select
            Time Complexity: O(n) in average, O(n^2) in worst case.
            Space Complexity: O(1)

        */

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            // we get a index of a pivot, left of which is all smaller and right to which is are all larger
            // int newPivotIndex = findNewPivotIndex(nums, low, high);
            int newPivotIndex = findNewPivotIndexRandomizedQS(nums, low, high);
            if(n - newPivotIndex == k) {
                // means this was the kth larget element
                return nums[newPivotIndex];
            } else if(n - newPivotIndex > k) {
                // suppose we got, n - newPivotIndex = 4th largest, but we wanted 2nd largest
                // means we need to go in right. (as all larger elements lie on right).
                low = newPivotIndex + 1;
            } else { // n - newPivotIndex < k
                // suppose we got, n - newPivotIndex = 4th largest, but we wanted 6th largest
                // means we need to go in left. (as all smaller elements lie on left).
                high = newPivotIndex - 1;
            }
        }

        return -1;
    }

    private int findNewPivotIndex(int[] nums, int l, int r) {
        /*  Approach: Quick Select
            Time Complexity: O(r - l)
            Space Complexity: O(1)
            Intuition:  fixing our pivot to right most element, we are trying to find a suitable index for
                        this pivot, where all the elements left to it is smaller and all right to it
                        are greater. so, we keep on scanning from left to (right - 1) th index, as right is
                        the pivot itself.
                        if element is smaller than pivot, then we swap it with our new pivot index element
                        and increment new pivot index, so that smaller element remains left to the new
                        pivot index, if greater we leave it as it is. now in the end all the smaller elements
                        are left to new pivot index and all greater right to it, except the pivot chosen
                        therefore, we swap it with new pivot index so that this new index has our selected
                        pivot element now.

        */

        int pivot = nums[r];
        int newPivotIndex = l;

        for(int i = l; i < r; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, newPivotIndex);
                newPivotIndex++;
            }
        }
        swap(nums, newPivotIndex, r);
        return newPivotIndex;
    }

    private int findNewPivotIndexRandomizedQS(int[] nums, int l, int r) {
        /*  Approach: Randomized Quick Select
            Time Complexity: O(r - l)
            Space Complexity: O(1)
            Intuition:  fixing our pivot to right most element, we are trying to find a suitable index for
                        this pivot, where all the elements left to it is smaller and all right to it
                        are greater. so, we keep on scanning from left to (right - 1) th index, as right is
                        the pivot itself.
                        if element is smaller than pivot, then we swap it with our new pivot index element
                        and increment new pivot index, so that smaller element remains left to the new
                        pivot index, if greater we leave it as it is. now in the end all the smaller elements
                        are left to new pivot index and all greater right to it, except the pivot chosen
                        therefore, we swap it with new pivot index so that this new index has our selected
                        pivot element now.

        */

        Random rand = new Random();
        int randomPivotIndex = rand.nextInt(r - l + 1) + l;
        swap(nums, randomPivotIndex, r);

        int pivot = nums[r];
        int newPivotIndex = l;

        for(int i = l; i < r; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, newPivotIndex);
                newPivotIndex++;
            }
        }
        swap(nums, newPivotIndex, r);
        return newPivotIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
