/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/valid-sudoku/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem36_ValidSudko {

    public boolean isValidSudoku(char[][] board) {
        // return approachOne(board);
        return approachTwo(board);
    }

    private boolean approachOne(char[][] board) {
        /*  Approach: hash Table
            Time Complexity: O(3 * n ^ 2)
            Space Complexity: O(2n + n ^ 2)
        */

        // validating rows
        for(int i = 0; i < 9; i++) {
            boolean[] rowHash = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!rowHash[board[i][j] - '0']) {
                        rowHash[board[i][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // validating columns
        for(int i = 0; i < 9; i++) {
            boolean[] colHash = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(!colHash[board[j][i] - '0']) {
                        colHash[board[j][i] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // validating 3 x 3 blocks
        boolean[][] hash = new boolean[10][10];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(i <= 2) {
                        if(j <= 2) {
                            // 00 01 02
                            // 10 11 12
                            // 20 21 22
                            if(!hash[0][board[i][j] - '0']) {
                                hash[0][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else if(j <= 5) {
                            // 03 04 05
                            // 13 14 15
                            // 23 24 25
                            if(!hash[1][board[i][j] - '0']) {
                                hash[1][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else {
                            // 06 07 08
                            // 16 17 18
                            // 26 27 28
                            if(!hash[2][board[i][j] - '0']) {
                                hash[2][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        }
                    } else if(i <= 5) {
                        if(j <= 2) {
                            // 30 31 32
                            // 40 41 42
                            // 50 51 52
                            if(!hash[3][board[i][j] - '0']) {
                                hash[3][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else if(j <= 5) {
                            // 33 34 35
                            // 43 44 45
                            // 53 54 55
                            if(!hash[4][board[i][j] - '0']) {
                                hash[4][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else {
                            if(!hash[5][board[i][j] - '0']) {
                                hash[5][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        }
                    } else {
                        if(j <= 2) {
                            if(!hash[6][board[i][j] - '0']) {
                                hash[6][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else if(j <= 5) {
                            if(!hash[7][board[i][j] - '0']) {
                                hash[7][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        } else {
                            if(!hash[8][board[i][j] - '0']) {
                                hash[8][board[i][j] - '0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }

                }
            }
        }

        return true;
    }


    private boolean approachTwo(char[][] board) {
        /*  Approach: hash Table
            Time Complexity: O(n ^ 2 -> (two loops) + len(string in hashSet) -> (to check contains before adding))
            Space Complexity: O(n ^ 2)
        */

        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!seen.add(board[i][j] + "in row " + i) ||
                            !seen.add(board[i][j] + "in col " + j) ||
                            !seen.add(board[i][j] + "in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
