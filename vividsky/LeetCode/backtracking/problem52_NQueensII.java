package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/n-queens-ii/
 * Difficulty level : Hard
 */
public class problem52_NQueensII {
    public int totalNQueens(int n) {
        return nQueens(new boolean[n][n], 0, n, 0);
    }

    private int nQueens(boolean[][] board, int row, int n, int count) {
        if (row == n) {
            count++;
            return count;
        }
        int c = 0;
        for (int col = 0; col < n; col++) {
            if (validMove(board, row, col)) {
                board[row][col] = true;
                c += nQueens(board, row + 1, n, count);
                board[row][col] = false;
            }
        }
        return c;
    }

    private boolean validMove(boolean[][] board, int row, int col) {

        int r = row;
        int c = col;
        while (r >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
        }

        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
