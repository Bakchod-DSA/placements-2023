package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Difficulty level : Medium
 */
public class problem215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        // return approachOne(nums, k);
        // return approachTwo(nums, k);
        return approachThree(nums, 0, nums.length - 1, k);
    }

    /**
     Time : nlog(n)
     Space : constant
     algo : sort all the elts and find kth largest ele which will be present at
     index n - k
     [3,2,1,5,6,4] after sorting -> [1,2,3,4,5,6] if k == 2,
     then 2nd largest is 5 present at 6 - 2 = 4th index
     */
    private int approachOne(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

    /**
     Heap (minHeap)

     Time : nlog(k)
     Space: k

     algo : keep a minHeap (default sorted in ascending elements) of size k
     keep addying elts in heap if ele > minHeap.peek()
     once we traversed all the elts, then peek of minHeap will be our kth largest element
     it takes log(p) time to insert element, where p is number of elements in heap
     since we iterate for all n elements, total time complexity will be nlog(k)
     */
    private int approachTwo(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int ele : nums) {
            if (minHeap.size() < k) {
                minHeap.add(ele);
            } else {
                if (ele > minHeap.peek()) {
                    minHeap.remove();
                    minHeap.add(ele);
                }
            }
        }
        return minHeap.peek();
    }

    /**
     Quick Select

     Time : nlog(k)
     Space: constant

     Algo : Sort the elements using quickSelect in descending order
     if partition idx == k - 1 -> this is the kth largest element
     if idx < k - 1 -> kth largest lies in right to idx -> shift start to idx + 1
     if idx > k - 1 -> kth largest lies in left to idx -> shift end to idx - 1
     */
    private int approachThree(int[] nums,int start, int end, int k) {
        int idx = partition(nums, start, end);
        if (idx == k - 1) {
            return nums[idx];
        } else if (idx > k - 1) {
            return approachThree(nums, start, idx - 1, k);
        } else {
            return approachThree(nums, idx + 1, end, k);
        }
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h, pivot = nums[l];
        while (i < j) {
            while (i < h && nums[i] >= pivot) {
                i++;
            }
            while (nums[j] < pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
