package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/unique-paths/
 * Difficulty level : Medium
 */
public class problem62_UniquePaths {
    public int uniquePaths(int m, int n) {
        return approachTwo(m, n);
    }

    private int approachOne(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }
        return cache[m - 1][n - 1];
    }

    /**
     Time : min(m, n)
     Space : constant
     Algo : This is a problem of combinations,
     If the matrix is 3x7, we have 10 grids to reach the finish because 3 + 7 = 10
     The maximum right moves we can have is 3 since it's a 3x7 matrix.
     The maximum down moves we can have is 7 since it's a 3x7 matrix.
     No. of ways in which we can choose the right turn?
     It's C(10,3) = 10! / (7! * 3!) => (m+n)! / (m!*n!)

     But once we reach the nearest grid to the finish grid,
     there will be only one way to reach the finish grid from current grid.
     And since we are already at start grid,
     there will be no other way to be at start grid,
     hence we need to decrement m and n by one unit
     */
    private int approachTwo(int m, int n) {
        m--;
        n--;
        m = m + n;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= m - n + i;
            result /= i;
        }
        return (int)result;
    }
}
