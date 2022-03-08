package LeetCode.pointers;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-k-closest-elements/
 * Difficulty level : Medium
 */
public class Xproblem658_FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // return approachThree(arr, k, x);
        return approachFour(arr, k, x);
    }

    /**
     Heap
     Time : O(NlogK)
     Algo : Add k closest elements to x in heap, if heap size > k pop farther element i.e.peek element and add closer element
     sort the array and return it
     */
    private List<Integer> approachFour(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> Math.abs(b - x) - Math.abs(a - x));
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else if (Math.abs(pq.peek() - x) > Math.abs(arr[i] - x)) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);
        return result;
    }

    /*
    BinarySearch

    Time : O(n - k)
    Space: constant
    Algo : we are trying to find l such that elements between [l, l + k] are the required elements
            for that we will keep l = 0 and h = arr.length() - 1 - k (to keep atleast k elements to right of h)
            as if we do not change h and keep incrementing l -> it will pass h and that window from h + 1 to end will be required one
            we will try to keep k + 1 elements in window once at a time as either one of the end elements will be included
            otherwise our window will be of k + 1 size, we keep adjusting our l and h accordingly
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

        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /*
    Two Pointers/ Sliding Window

    Time : O(n - k)
    Space: constant
    ALgo : keep two pointers at extremes i.e. at start and end
            keep decreasing window size until we get end - start = k that is,
            we have exactly k elements in our window
            to decrease size of window check if start ele distance is less than end element distance
            whichever is larger -> decrement/increment accordingly
    Note : It is mentioned if we have two elements with same difference, always consider smaller one first
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

    /**
     Algo : First find closest element to x smaller than x
     if its not equal to x and not the end element of array, check if idx + 1th elemnet is closer to x or not
     if so, update idx -> idx + 1
     choose l and h wisely one element is idx element for sure
     initialise l and h as idx - 1 and idx + 1 resp.

     Note : keep edge cases in mind (what id idx == 0 or idx == arr.length)
     */
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

    /**
     Binary search to find largest element that is smaller than x and closest element to x
     e.g. [1,2,3,5,6] x = 4 ans will be 3 (not 5)
     */
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
