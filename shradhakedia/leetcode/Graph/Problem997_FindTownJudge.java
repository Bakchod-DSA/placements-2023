/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-the-town-judge/
 * Difficulty level: Easy
 */

package leetcode.Graph;

import java.util.*;

public class Problem997_FindTownJudge {

    Set<Integer>[] graph;

    public int findJudge(int n, int[][] trust) {

        return approachTwo(n, trust);

//         /*  Approach: Hashtable + graph
//             Time Complexity: O(3n + e), n + e for buildGraph. e = edges.length
//             Space Complexity: O(n ^ 2)
//         */

//         buildGraph(n, trust);

//         int townJudge = -1;
//         for(int i = 1; i <= n; i++) {
//             if(graph[i].isEmpty()) {
//                 townJudge = i;
//                 break;
//             }
//         }

//         for(int i = 1; i <= n; i++) {
//             if(townJudge != -1 && townJudge != i) {
//                 if(graph[i].contains(townJudge)) {
//                     continue;
//                 } else {
//                     townJudge = -1;
//                     break;
//                 }
//             }
//         }

//         return townJudge;
    }

    private void buildGraph(int n, int[][] trust) {
        /*  Approach: Graph representation: Adjacency list.
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n ^ 2)
        */

        graph = new Set[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }

        for(int[] t : trust) {
            graph[t[0]].add(t[1]);
        }
    }

    private int approachTwo(int n, int[][] trust) {
        /*  Intuition: Consider trust as a graph, all pairs are directed edge. The point with in-degree - out-degree = N - 1 become the judge.
            Explanation: Count the degree, and check at the end.
            Time Complexity: O(T + N),
            Space Complexity: O(N)
        */

        int[] count = new int[n + 1];

        for(int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(count[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
