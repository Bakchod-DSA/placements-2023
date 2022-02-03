package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/unique-paths-ii/
 * Difficulty level : Medium
 */
public class problem63_UniquePathsII {
    int[][] cache;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        // return approachOne(obstacleGrid, 0, 0);
        return approachTwo(obstacleGrid);
    }

    private int approachTwo(int[][] oGrid) {
        int r = oGrid.length;
        int c = oGrid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    if (oGrid[i][j] == 1) {
                        oGrid[i][j] = 0;
                    } else {
                        oGrid[i][j] = 1;
                    }
                } else if (i == 0) {
                    if (oGrid[i][j] == 1) {
                        oGrid[i][j] = 0;
                    } else {
                        oGrid[i][j] = oGrid[i][j - 1];
                    }
                } else if (j == 0) {
                    if (oGrid[i][j] == 1) {
                        oGrid[i][j] = 0;
                    } else {
                        oGrid[i][j] = oGrid[i - 1][j];
                    }
                } else {
                    if (oGrid[i][j] == 1) {
                        oGrid[i][j] = 0;
                    } else {
                        oGrid[i][j] = oGrid[i][j - 1] + oGrid[i - 1][j];
                    }
                }
            }
        }
        return oGrid[r - 1][c - 1];
    }


    private int approachOne(int[][] oGrid, int col, int row) {

        if (col == oGrid[0].length - 1 && row == oGrid.length - 1 && oGrid[row][col] != 1) {
            return 1;
        } else if (col < oGrid[0].length && row < oGrid.length && oGrid[row][col] != 1 && oGrid[row][col] != 2) {

            int count = 0;

            if (cache[row][col] != 0)
                return cache[row][col];

            oGrid[row][col] = 2;
            count += approachOne(oGrid, col + 1, row);
            count += approachOne(oGrid, col, row + 1);

            oGrid[row][col] = 0;
            cache[row][col] = count;

            return count;
        }
        return 0;
    }
}
