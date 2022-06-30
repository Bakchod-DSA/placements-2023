/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/flood-fill/
 * Difficulty level: Easy
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        boolean[][] visited = new boolean[image.length][image[0].length];

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                Cell polled = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int newX = polled.x + dx[i];
                    int newY = polled.y + dy[i];
                    if(isValid(image, visited, newX, newY, originalColor)) {
                        visited[newX][newY] = true;
                        image[newX][newY] = color;
                        queue.add(new Cell(newX, newY));
                    }
                }
            }
        }

        return image;
    }

    private boolean isValid(int[][] image, boolean[][] visited, int x, int y, int originalColor) {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || visited[x][y] || image[x][y] != originalColor) return false;
        return true;
    }

    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
