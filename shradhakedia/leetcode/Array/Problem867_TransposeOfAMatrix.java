/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/transpose-matrix/
 * Difficulty level: Easy
 */
package leetcode.Array;

public class Problem867_TransposeOfAMatrix {
    public int[][] transpose(int[][] matrix) {
        /*  Approach: matrix, transpose
            Time Complexity: O(mn)
            Space Complexity: O(mn)
        */
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transpose = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }
}
