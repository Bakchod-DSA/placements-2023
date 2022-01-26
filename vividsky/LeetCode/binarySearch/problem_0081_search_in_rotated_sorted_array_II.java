package LeetCode.binarySearch;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Difficulty level : Medium
 */
public class problem_0081_search_in_rotated_sorted_array_II {
    public boolean search(int[] nums, int target) {
        return approachTwo(nums, target);
    }

    /*
    Time complexity : average nlog(n), worst O(n)
    space complexity : constant
    algo : Find the rotation unit i.e. the index of min ele
            add that index to current mid index (gives mid of shifted array)
            and modulo it by len od array (for rotated nature) and do BS
    */
    private boolean approachTwo(int[] nums, int target) {

        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int rot = findRotation(nums);
        System.out.println(rot);

        while (l <= h) {
            int m = (l + h) >> 1;
            int am = (m + rot) % n;
            if (nums[am] == target) return true;
            else if (nums[am] > target) h = m - 1;
            else l = m + 1;
        }
        return false;
    }

    /*
    To find rotation unit : worst case linear, if almost all elements are same
    */
    private int findRotation(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                for (int i = low; i < high; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return i + 1;
                    }
                }
                return low;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;

    }

    /*
    time complexity : average nlog(n), worst O(n)
    algo : try to look where mid and target element lies,
        * arr[mid] lies in F, target lies in S: Since S starts after F ends,
            we know that element lies here:(mid, end].
        * arr[mid] lies in the S, target lies in F: Similarly,
            we know that element lies here: [start, mid).
        * Both arr[mid] and target lie in F or S: since both of them are in same sorted array,
            we can compare arr[mid] and target in order to decide how to reduce search space.
        * But there is a catch, if arr[mid] equals arr[start],
            then we know that arr[mid] might belong to both F and S
            and hence we cannot find the relative position of target from it.
            In this case, we have no option but to move to next search space iteratively.
    */
    private boolean approachOne(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int m = (l + h) >> 1;

            if (nums[m] == target) return true;

            if (!binarySearchHelpful(nums, m, l)) {
                l++;
                continue;
            } else {

                boolean pivotPosition = elePosition(nums, l, nums[m]);
                boolean targetPosition = elePosition(nums, l, target);

                if (pivotPosition ^ targetPosition) {
                    if (pivotPosition) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                } else {
                    if (nums[m] < target) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                }
            }
        }
        return false;
    }

    /*
    If target > arr[start]: target exists in the first array F.
    If target < arr[start]: target exists in the second array S
    If target == arr[start]: target obviously exists in the first array F,
    but it might also be present in the second array S.
    */
    private boolean elePosition(int[] nums, int start, int target) {
        return nums[start] <= target;
    }

    /*
    if arr[mid] == arr[start], then arr[mid] might belong to both F and S
    and hence we cannot find the relative position of target from it.
    BS might not be helpful, hence we will increment our low and
    move to next search space iteratively.
    */
    private boolean binarySearchHelpful(int[] nums, int mid, int start) {
        return nums[mid] != nums[start];
    }

}
