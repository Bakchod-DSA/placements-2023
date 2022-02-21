package EPI.BinarySearch;
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
        return approachThree(nums, k);
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
     Time : nlog(k)
     Space: k
     DS used : minHeap (PriorityQueue)
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


    private int approachThree(int[] nums, int k) {
        int val = -1;
        int n = nums.length;
        int j = partition(nums, 0, n - 1);
        if (n - j == k) {
            return nums[j];
        } else if (n - j > k) {
            val = approachThree(Arrays.copyOfRange(nums, j + 1, n), k);
        } else {
            val = approachThree(Arrays.copyOfRange(nums, 0, j), k - n + j);
        }
        return val;
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h, pivot = nums[l];
        while (i < j) {
            while (i < h && nums[i] <= pivot) {
                i++;
            }
            while (nums[j] > pivot) {
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
