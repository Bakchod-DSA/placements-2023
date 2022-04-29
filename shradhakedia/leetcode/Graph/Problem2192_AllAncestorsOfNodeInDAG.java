/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem2192_AllAncestorsOfNodeInDAG {

    List<List<Integer>> allAncestors;
    List<Set<Integer>> sample;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // return approachOne(n, edges);
        return approachTwo(n, edges);
    }

    private List<List<Integer>> approachOne(int n, int[][] edges) {
        /*  Approach: dfs
            Time Complexity: O(n + e + n((n + e) + xlogx)), x = ancestors size for a node.
            Space Complexity: O(n + e + n)
        */

        allAncestors = new ArrayList<>();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[v].add(u);
        }

        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited, 0);
            List<Integer> ancestors = new ArrayList<>();
            dfs(i, visited, graph, ancestors);
            Collections.sort(ancestors);
            allAncestors.add(ancestors);
        }

        return allAncestors;
    }

    private void dfs(int v, int[] visited, LinkedList<Integer>[] graph, List<Integer> ancestors) {
        visited[v] = 1;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                ancestors.add(child);
                dfs(child, visited, graph, ancestors);
            }
        }
    }

    private List<List<Integer>> approachTwo(int n, int[][] edges) {
        /*  Approach: Topological Sorting
            Time Complexity: O(n + e + (n + e)x + nx + nxlogx)), x = ancestors size for a node. sample size = n.
            Space Complexity: O(n + e + 2nx)
        */

        allAncestors = new ArrayList<>();
        sample = new ArrayList<>();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
            sample.add(new HashSet<>());
        }

        int[] inDegree = new int[n];
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            inDegree[v]++;
        }



        kahn(n, graph, inDegree);

        for(Set<Integer> ancestor : sample) {
            allAncestors.add(new ArrayList<>(ancestor));
        }
        for(List<Integer> ancestor : allAncestors) {
            Collections.sort(ancestor);
        }

        return allAncestors;
    }

    private void kahn(int n, LinkedList<Integer>[] graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for(int child : graph[node]) {
                sample.get(child).addAll(sample.get(node));
                sample.get(child).add(node);

                inDegree[child]--;
                if(inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
    }
}
