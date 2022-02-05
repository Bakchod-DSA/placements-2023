/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/n-queens/
 * Difficulty level: Hard
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem51_NQueens {

    public List<List<String>> solveNQueens(int n) {


        List<List<String>> list = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        approachOne(list, 0, 0, 0, n, board);

        return list;

    }

    private void approachOne(List<List<String>> list, int row, int col, int qpsf, int tq, char[][] board) {
        /*  Approach: BackTracking
            Time Complexity: O(n! + 3n + n^2), n! all the possible combinations queens can sit.
                             3n worst case to check queen safe. row = end row, col = end column, left up diagonal so total
                             3n ways, n^2 for forming ans (construct board).
            Space Complexity: O(n + n * n), n for recursive stack. n * n for board.
        */

        if(qpsf == tq) {
            // +ve base case
            list.add(constructBoard(board));
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
            board[row][col] = 'Q';
            approachOne(list, row, col + 1, qpsf + 1, tq, board);
            board[row][col] = '.';

        }

        // not placed
        approachOne(list, row, col + 1, qpsf, tq, board);

    }

    private boolean isItSafeToPlaceTheQueen(char[][] board, int row, int col) {

        // check horizontally left
        for(int j = 0; j < col; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // check vertically upward
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }


        // check diagonally left
        int r = row;
        int c = col;
        while(r - 1 >= 0 && c - 1 >= 0) {
            if(board[r - 1][c - 1] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // check diagonally right
        r = row;
        c = col;
        while(r - 1 >= 0 && c + 1 < board[0].length) {
            if(board[r - 1][c + 1] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private List<String> constructBoard(char[][] board) {

        List<String> rows = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {

            String row = "";
            for(int j = 0; j < board[0].length; j++) {
                row += board[i][j];
            }

            rows.add(row);
        }

        return rows;
    }

}
