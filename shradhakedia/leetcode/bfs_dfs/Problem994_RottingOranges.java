/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/rotting-oranges/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int totalFreshOranges = 0;

        Deque<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    totalFreshOranges++;
                }

                if(grid[i][j] == 2) {
                    queue.addLast(new Coordinate(i, j));
                    visited[i][j] = true;
                }
            }
        }

        return bfs(queue, grid, visited, totalFreshOranges);
    }


    private int bfs(Deque<Coordinate> queue, int[][] grid, boolean[][] visited, int totalFreshOranges) {
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int time = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for(int i = 0; i < size; i++) {
                Coordinate vertex = queue.removeFirst();
                int x = vertex.x;
                int y = vertex.y;

                for(int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if(isValid(newX, newY, grid, visited)) {
                        visited[newX][newY] = true;
                        totalFreshOranges--;
                        grid[newX][newY] = 2;
                        queue.addLast(new Coordinate(newX, newY));
                    }
                }
            }
        }

        if(totalFreshOranges == 0) {
            if(time == 0) return 0;
            else return time - 1;
        } else {
            return -1;
        }
    }

    private boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        if(i < 0 || i == grid.length) return false;
        if(j < 0 || j == grid[0].length) return false;
        if(visited[i][j] || grid[i][j] == 0 || grid[i][j] == 2) return false;
        return true;
    }

    class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
