/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-height-trees/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem310_MinimumHeightTrees {

    int[] visited;
    int[] in;
    Set<Integer>[] graph;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return Arrays.asList(0);
        }

        buildGraph(n, edges);

        // return approachOne(n);
        return approachTwo(n);
    }

    private void buildGraph(int n, int[][] edges) {
        /*  Approach: Graph representation: Adjacency list.
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n ^ 2)
        */

        graph = new Set[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        in = new int[n];
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            in[edge[0]]++;
            in[edge[1]]++;
        }
    }

    private List<Integer> approachOne(int n) {
        /*  gives TLE
            Approach: bfs on each node
            Time Complexity: O(n(n + e))
            Space Complexity: O(n + e)
        */

        List<Integer> msts = new ArrayList<>();
        int minH = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            visited = new int[n];
            int h = bfs(i);

            if(minH > h) {
                msts.clear();
                msts.add(i);
                minH = h;
            } else if(minH == h) {
                msts.add(i);
            }
        }

        return msts;
    }

    private int bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = 1;
        queue.add(source);
        int h = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            h++;
            for(int i = 0; i < size; i++) {
                int node = queue.remove();
                for(int child : graph[node]) {
                    if(visited[child] == 0) {
                        visited[child] = 1;
                        queue.add(child);
                    }
                }
            }
        }

        return h;
    }

    private List<Integer> approachTwo(int n) {
        int remainingNode = n;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> newLeaves;

        for(int i = 0; i < n; i++) {
            if(in[i] == 1) {
                queue.add(i);
            }
        }

        while(remainingNode > 2) {
            newLeaves = new LinkedList<>();
            remainingNode -= queue.size();
            while(!queue.isEmpty()) {
                int leaf = queue.remove();
                int parent = graph[leaf].iterator().next();
                graph[parent].remove(leaf);
                if(--in[parent] == 1) {
                    newLeaves.add(parent);
                }
            }

            queue = newLeaves;

        }

        return new ArrayList<>(queue);
    }
}
