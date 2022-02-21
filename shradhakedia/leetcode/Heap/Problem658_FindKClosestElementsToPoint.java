/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-k-closest-elements/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem658_FindKClosestElementsToPoint {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        // return approachOne(arr, k, x);

        // List<Integer> kClosestIntegers = new ArrayList<>();
        // int start = approachTwo(arr, k, x);
        // for(int i = start; i < start + k; i++) {
        //     kClosestIntegers.add(arr[i]);
        // }
        // return kClosestIntegers;

        return approachThree(arr, k, x);

    }

    private List<Integer> approachOne(int[] arr, int k, int x) {
        /*  Approach 1: Binary Search + Intutive(Two Pointers)
            Time Complexity: O(log(n) + 2k)
            Space Complexity: O(1)
        */

        int index = findAClosestIntegerToX(arr, x);
        int start = index - 1, end = index + 1;

        while(k - 1 > 0) {
            int diff1 = (start >= 0)? Math.abs(arr[start] - x) : Integer.MAX_VALUE;
            int diff2 = (end < arr.length)? Math.abs(arr[end] - x) : Integer.MAX_VALUE;

            if(diff1 <= diff2) {
                start--;
            } else {
                end++;
            }

            k--;
        }

        List<Integer> kClosestIntegers = new ArrayList<>();
        for(int i = start + 1; i < end; i++) {
            kClosestIntegers.add(arr[i]);
        }
        return kClosestIntegers;
    }

    private int findAClosestIntegerToX(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(arr[mid] < x) {
                low = mid + 1;
            } else if(arr[mid] == x) {
                return mid;
            } else {
                high = mid;
            }
        }
        // compare which is close, high or high - 1, if equal return high - 1 (acc. to question constraints)
        return (high == 0)? high: (Math.abs(arr[high - 1] - x) <= Math.abs(arr[high] - x))? high - 1 : high;
    }

    private int approachTwo(int[] arr, int k, int x) {
        /*  Approach : Binary Search
            Time Complexity: O(log n)
            SpaceComplexity: O(1)
        */

        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = low + ((high - low) >> 1);

            if(x - arr[mid] <= arr[mid + k] - x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private List<Integer> approachThree(int[] arr, int k, int x) {
        /*  Approach : max Heap (Priority Queue)
            Time Complexity: O(n logk + k logk), n logk for adding in heap and poll, k logk for sorting the array again in ascending
                             order, we need to sort it because heap is sorted according to the distance from x. but we need in ans
                             in ascending order irrespective of their distance from x.
            SpaceComplexity: O(k)
        */

        Queue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> (Math.abs(b - x) - Math.abs(a - x)) == 0? b - a : Math.abs(b - x) - Math.abs(a - x));

        for (int j : arr) {
            maxHeap.add(j);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>(maxHeap);

        Collections.sort(result);
        return result;
    }

}
