package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/n-queens/
 * Difficulty level : Hard
 */
public class problem51_NQueens {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        nQueens(board, n, 0);
        return result;
    }

    private void nQueens(char[][] board, int n, int row) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++)  {
            if (isItSafeToPlaceQueen(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> oneValidCombination = new ArrayList<>();
        for (char[] row : board) {
            oneValidCombination.add(new String(row));
        }
        return oneValidCombination;
    }

    private boolean isItSafeToPlaceQueen(char[][] board, int row, int col) {

        int r = row;
        int c = col;
        while (r >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
        }

        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}
