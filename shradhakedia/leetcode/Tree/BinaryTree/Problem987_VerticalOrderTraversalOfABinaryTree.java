/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Difficulty level: Medium
 */
package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem987_VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer,PriorityQueue<Integer>>> sortedMap = new TreeMap<>();

        bfs(sortedMap, root);
        List<List<Integer>> verticalLists = formVerticalLists(sortedMap);

        return verticalLists;
    }

    private void bfs(Map<Integer, Map<Integer,PriorityQueue<Integer>>> sortedMap, TreeNode root) {
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Pair nodeWithLevel = queue.poll();
                int verticalLevel = nodeWithLevel.verticalLevel;
                int horizontalLevel = nodeWithLevel.horizontalLevel;
                TreeNode node = nodeWithLevel.node;

                if(!sortedMap.containsKey(verticalLevel)) {
                    sortedMap.put(verticalLevel, new TreeMap<>());
                }
                if(!sortedMap.get(verticalLevel).containsKey(horizontalLevel)) {
                    sortedMap.get(verticalLevel).put(horizontalLevel, new PriorityQueue<>());
                }
                sortedMap.get(verticalLevel).get(horizontalLevel).offer(node.val);

                if(node.left != null) queue.add(new Pair(node.left, verticalLevel - 1, horizontalLevel + 1));
                if(node.right != null) queue.add(new Pair(node.right, verticalLevel + 1, horizontalLevel + 1));
            }
        }
    }

    private List<List<Integer>> formVerticalLists(Map<Integer, Map<Integer,PriorityQueue<Integer>>> sortedMap) {
        List<List<Integer>> verticalLists = new ArrayList<>();

        for(Map<Integer, PriorityQueue<Integer>> map : sortedMap.values()) {
            verticalLists.add(new ArrayList<>());
            for(PriorityQueue<Integer> verticalList : map.values()) {
                while (!verticalList.isEmpty()) {
                    verticalLists.get(verticalLists.size() - 1).add(verticalList.poll());
                }
            }
        }

        return verticalLists;
    }


    class Pair {
        TreeNode node;
        int verticalLevel;
        int horizontalLevel;
        Pair(TreeNode node, int verticalLevel, int horizontalLevel) {
            this.node = node;
            this.verticalLevel = verticalLevel;
            this.horizontalLevel = horizontalLevel;
        }
    }
}
