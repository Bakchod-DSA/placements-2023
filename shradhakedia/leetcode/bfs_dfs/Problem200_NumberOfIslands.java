/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/number-of-islands/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        int countConnComponents = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    countConnComponents++;
                    // dfs(grid, visited, dx, dy, i, j);
                    bfs(grid, visited, dx, dy, i, j);
                }
            }
        }

        return countConnComponents;
    }

    private void bfs(char[][] grid, boolean[][] visited, int[] dx, int[] dy, int x, int y) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Cell popped = queue.remove();
            int X = popped.x;
            int Y = popped.y;
            for(int i = 0; i < 4; i++) {
                int neighX = X + dx[i];
                int neighY =  Y + dy[i];

                if(isValid(neighX, neighY, grid, visited)) {
                    visited[neighX][neighY] = true;
                    queue.add(new Cell(neighX, neighY));
                }
            }
        }
    }

    private void dfs(char[][] grid, boolean[][] visited, int[] dx, int[] dy, int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            if(isValid(x + dx[i], y + dy[i], grid, visited)) {
                dfs(grid, visited, dx, dy, x + dx[i], y + dy[i]);
            }
        }
    }

    private boolean isValid(int x, int y, char[][] grid, boolean[][] visited) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') return false;
        return true;
    }
    class Cell {
        int x, y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
