/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-a-2d-matrix/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem74_SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Approach 1: Binary Search;
        // Time Complexity: O(log m + log n), Space Complexity: O(1)


        // find row first
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m - 1;
        int index = -1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(matrix[mid][0] == target || matrix[mid][n - 1] == target) {
                return true;
            } else if(matrix[mid][0] > target && matrix[mid][n - 1] > target) {
                high = mid - 1;
            } else if(matrix[mid][0] < target && matrix[mid][n - 1] < target) {
                low = mid + 1;
            } else if(matrix[mid][0] < target && matrix[mid][n - 1] > target) {
                index = mid;
                break;
            }
        }

        // find column
        if(index == -1) return false;
        low = 0; high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(matrix[index][mid] == target) {
                return true;
            } else if(matrix[index][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
