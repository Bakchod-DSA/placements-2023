package LeetCode.binarySearch;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/h-index-ii/
 * Difficulty level : Medium
 */
public class problem0275_HIndexII {
    /*
    Time : log(n)
    Space: constant
    algo :  case 1: citations[mid] == len-mid, then it means there are atleast citations[mid]
            papers that have atleast citations[mid] citations.
            case 2: citations[mid] > len-mid, then it means there are citations[mid] papers that have more than
            citations[mid] citations, so we should continue searching in the left half
            case 3: citations[mid] < len-mid, we should continue searching in the right side
            After iteration, it is guaranteed that right+1 is the one we need to find (i.e. len-(right+1) papars have at least
            len-(righ+1) or len - left (as once we exit loop low = high + 1) citations)
    */
    public int hIndex(int[] citations) {

        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int h = citations[mid];
            if (h == n - mid) {
                return h;
            } else if (h > n - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - low;
    }
}
