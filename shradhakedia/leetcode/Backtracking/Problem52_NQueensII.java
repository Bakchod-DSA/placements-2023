/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/n-queens-ii/
 * Difficulty level: Hard
 */

package leetcode.Backtracking;

public class Problem52_NQueensII {

    public int totalNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        int[] count = new int[1];

        approachOne(count, 0, 0, 0, n, board);

        return count[0];

    }

    private void approachOne(int[] count, int row, int col, int qpsf, int tq, boolean[][] board) {
        /*  Approach: BackTracking
            Time Complexity:  O(n! + 3n), n! all the possible combinations queens can sit.
                              3n worst case to check queen safe. row = end row, col = end column, left up diagonal so total
                              3n ways.
            Space Complexity: O(n + n * n), n for recursive stack. n * n for board.
        */

        if(qpsf == tq) {
            // +ve base case
            count[0]++;
            return;
        }

        if(col == board[0].length) {
            // manually change variables
            col = 0;
            row++;
        }

        if(row == board.length) {
            // -ve base case
            return;
        }

        if(isItSafeToPlaceTheQueen(board, row, col)) {

            //placed
            board[row][col] = true;
            approachOne(count, row, col + 1, qpsf + 1, tq, board);
            board[row][col] = false;

        }

        // not placed
        approachOne(count, row, col + 1, qpsf, tq, board);

    }

    private boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {

        // check horizontally left
        for(int j = 0; j < col; j++) {
            if(board[row][j]) {
                return false;
            }
        }

        // check vertically upward
        for(int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }


        // check diagonally left
        int r = row;
        int c = col;
        while(r - 1 >= 0 && c - 1 >= 0) {
            if(board[r - 1][c - 1]) {
                return false;
            }
            r--;
            c--;
        }

        // check diagonally right
        r = row;
        c = col;
        while(r - 1 >= 0 && c + 1 < board[0].length) {
            if(board[r - 1][c + 1]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

}
