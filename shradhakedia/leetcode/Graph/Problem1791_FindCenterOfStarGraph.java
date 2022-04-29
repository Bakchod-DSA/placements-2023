/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-center-of-star-graph/
 * Difficulty level: Easy
 */

package leetcode.Graph;

import java.util.*;

public class Problem1791_FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {

        // Approach 1: Observation: Reading the description carefully helps here. Basically, a center node must appear in every edge.
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])? edges[0][0] : edges[0][1];

        /* Approach 2: graph representation: adjacency list.
        List<Integer>[] graph = buildGraph(edges);

        for(int i = 1; i < graph.length; i++) {
            if(graph[i].size() == edges.length) {
                return i;
            }
        }

        return -1;
        */
    }

    private List<Integer>[] buildGraph(int[][] edges) {
        /*  Approach: Graph representation: Adjacency list.
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n ^ 2)
        */

        int n = edges.length + 2;
        List<Integer>[] graph = new List[n];

        for(int i = 1; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
}
