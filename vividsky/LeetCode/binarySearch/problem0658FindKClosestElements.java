package LeetCode.binarySearch;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-k-closest-elements/
 * Difficulty level : Medium
 */

public class problem0658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return approachThree(arr, k, x);
    }

    /*
    Time : O(n - k)
    Space : constant
    */
    private List<Integer> approachThree(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int l = 0;
        int h = arr.length - k - 1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        for (int i = h + 1; i < h + 1 + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /*
    Two Pointers
    Time complexity : O(n - k)
    Space complexity : constant
    */
    private List<Integer> approachTwo(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            if (arr[end] - x >= x - arr[start]) {
                end--;
            } else {
                start++;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> approachOne(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int idx = findPossibleXIndex(arr, x);

        if (idx != -1 && arr[idx] != x) {
            if (idx < arr.length - 1 && x - arr[idx] > arr[idx + 1] - x) {
                idx = idx + 1;
            }
        }

        int l = idx - 1;
        int h = idx + 1;
        if (idx <= 0) {
            l = -1;
            h = l + 2;
        }
        if (idx >= arr.length - 1) {
            h = arr.length;
            l = h - 2;
        }

        while (k > 1) {
            if (l < 0) {
                h++;
            } else if (h >= arr.length) {
                l--;
            } else if (x - arr[l] <= arr[h] - x) {
                l--;
            } else {
                h++;
            }
            k--;
        }
        for (int i = l + 1; i < h; i++) {
            result.add(arr[i]);
        }
        return result;

    }

    private int findPossibleXIndex(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
