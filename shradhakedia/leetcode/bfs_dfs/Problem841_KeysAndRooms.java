/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/keys-and-rooms/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem841_KeysAndRooms {
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];

        dfs(0, rooms);
        for(int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    private void dfs(int src, List<List<Integer>> rooms) {
        visited[src] = true;
        for(int child : rooms.get(src)) {
            if(!visited[child] && child != src) {
                dfs(child, rooms);
            }
        }
    }
}
