/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/clone-graph/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem133_CloneGraph {

    public Node cloneGraph(Node node) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n + e for graph, n for visited.
        */

        if(node == null) return null;

        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        dfs(node, copy, visited);

        return copy;

    }

    private void dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;

        for(Node n : node.neighbors) {
            if(visited[n.val] == null) {
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);

                dfs(n, newNode, visited);
            } else {
                copy.neighbors.add(visited[n.val]);
            }
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

}
