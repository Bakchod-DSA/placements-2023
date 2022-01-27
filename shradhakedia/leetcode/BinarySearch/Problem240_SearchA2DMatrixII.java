/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem240_SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        return approachOne(matrix, target);
    }

    private boolean approachOne(int[][] matrix, int target) {
        // Approach 1: Binary Search;
        // Time Complexity: O(m log(n)), Space Complexity: O(1)
        for(int i = 0; i < matrix.length; i++) {
            if(binarySearch(matrix, i, target)) return true;

        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int target) {
        int low = 0;
        int high = matrix[0].length - 1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean approachTwo(int[][] matrix, int target) {
        // Approach 2: choosing top right corner, moving to left/bottom according to choice;
        // Time Complexity: O(m + n), Space Complexity: O(1)
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
