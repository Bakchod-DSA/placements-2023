/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/top-k-frequent-elements/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem347__TopKFrequentElements__ {

    public int[] topKFrequent(int[] nums, int k) {

        // return approachOne(nums, k);
        // return approachTwo(nums, k);
        // return approachThree(nums, k);
        return approachFour(nums, k);
    }

    private int[] approachOne(int[] nums, int k) {
        /*  Approach: Priority Queue (max Heap)
            Time Complexity: O(n + nlogn)
            Space Complexity: O(n + n),  to store the hash map with not more n elements and a heap with n elements.
        */

        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> maxCountHeap = new PriorityQueue<>((i1, i2) -> map.get(i2) - map.get(i1));
        for(Map.Entry<Integer, Integer> entrySet: map.entrySet()) {
            maxCountHeap.add(entrySet.getKey());
        }

        int[] result = new int[k];
        int i = 0;
        while(k > 0) {
            result[i++] = maxCountHeap.poll();
            k--;
        }

        return result;
    }


    private int[] approachTwo(int[] nums, int k) {
        /*  Approach: Priority Queue (min Heap)
            Time Complexity: O(n + nlog k + klog k)  if k < n and, O(n) in the particular case of n = k.
                             That ensures time complexity to be better than O(nlogn).
            Space Complexity: O(n + k),  to store the hash map with not more n elements and a heap with k elements.
        */

        // O(1) time
        if (k == nums.length) {
            // means all elements were unique in nums
            return nums;
        }

        // 1. build hash map : element and how often it appears(its count)
        // O(N) time
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // init heap 'the less frequent element first' -> minCountHeap
        PriorityQueue<Integer> minCountHeap = new PriorityQueue<>((i1, i2) -> map.get(i1) - map.get(i2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time (better than approachOne)
        for(Map.Entry<Integer, Integer> entrySet: map.entrySet()) {
            minCountHeap.add(entrySet.getKey());

            if(minCountHeap.size() > k) {
                minCountHeap.poll();
            }
        }

        // 3. build an output array
        // O(k log k) time
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = minCountHeap.poll();
        }

        return result;
    }

    private int[] approachThree(int[] nums, int k) {
        /*  Approach: Quick Select
            Time Complexity: O(n), O(n ^ 2) in worst case.
            Space Complexity: O(n + n),  to store the hash map with not more n elements and array to store unique elements.
        */

        // O(1) time
        if (k == nums.length) {
            // means all elements were unique in nums
            return nums;
        }

        // 1. build hash map : element and how often it appears(its count)
        // O(N) time
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. build unique elements array from keys of map
        // O(map.size()) time
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entryset : map.entrySet()) {
            arr[i++] = entryset.getKey();
        }

        // 3. sort array using quickselect and find the index after which there are k most frequent elements.
        int kthIndex = quickSelect(arr, map, k);

        // 4. build an output array
        // O(k)
        int[] result = new int[k];
        for(i = 0; i < k; i++) {
            result[i] = arr[kthIndex + i];
        }

        return result;
    }

    private int quickSelect(int[] arr, HashMap<Integer, Integer> map, int k) {

        int n = arr.length;

        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int pivotIdx = end;
            int newPivotIdx = findPivot(arr, map, start, pivotIdx);

            if(n - newPivotIdx > k) {
                start = newPivotIdx + 1;
            } else if(n - newPivotIdx < k) {
                end = newPivotIdx - 1;
            } else {
                return newPivotIdx;
            }
        }

        return -1;
    }

    private int findPivot(int[] arr, HashMap<Integer, Integer> map, int start, int pivotIndex) {

        int pivot = arr[pivotIndex];
        int newPivotIdx = start;

        for(int i = start; i < pivotIndex; i++) {

            if(map.get(arr[i]) < map.get(pivot)) {
                swap(arr, i, newPivotIdx);
                newPivotIdx++;
            }
        }
        swap(arr, pivotIndex, newPivotIdx);

        return newPivotIdx;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int[] approachFour(int[] nums, int k) {
        /* Approach: bucketSort
           Time Complexity: O(n + n), n for adding in hashmap, n for adding in bucket.
           Space Complexity: O(n + n), n for hashmap, n space for each bucket at max.
        */

        // 1. build HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. build buckets sorting them according to frequency
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entryset : map.entrySet()) {
            int freq = entryset.getValue();
            int ele = entryset.getKey();

            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ele);
        }

        // 3. build ans
        int[] ans = new int[k];
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) {
                System.out.println(bucket[i]);
                if(bucket[i].size() < k) {
                    for(int j = 0; j < bucket[i].size(); j++) {
                        ans[--k] = bucket[i].get(j);
                    }
                } else {
                    for(int j = k - 1; j >= 0; j--) {
                        ans[j] = bucket[i].get(j);
                        k--;
                    }
                    break;
                }
            }
        }

        return ans;

    }

}
