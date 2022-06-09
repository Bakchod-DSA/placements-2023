/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/rotate-image/
 * Difficulty level: Medium
 */
package leetcode.Array;

public class Problem48_RotateImage {

    public void rotate(int[][] matrix) {
        /*  Approach: matrix, transpose and reverse
            Time Complexity: O(n ^ 2)
            Space Complexity: O(1)
        */
        // transpose and reverse the cols
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                swap(matrix, i , j);
            }
        }
        // reverse cols
        int mid = n/2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
