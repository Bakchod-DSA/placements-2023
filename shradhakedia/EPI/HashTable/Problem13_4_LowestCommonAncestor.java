/**
 * Author : Sradha Kedia
 * Page no.: 216 of Epi Java
 * Problem no.: 13.4
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.*;

public class Problem13_4_LowestCommonAncestor {

    static class BinaryTree<Integer> {
        BinaryTree<Integer> parent;

        public BinaryTree(BinaryTree<Integer> parent) {
            this.parent = parent;
        }
    }


    public static BinaryTree<Integer> lca(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        /*  Approach: Hash Table
            Time Complexity: O(d0 + d1)
            Space Complexity: O(d0 + d1), where d0 = distance from LCA to node0
                              and d1 = distance from LCA to node 1
                              Worst Case can be when the two nodes are leaves and LCA is the root then we consume
                              O(h) time and space.
        */

        Set<BinaryTree<Integer>> seen = new HashSet<>();

        while(node0 != null || node1 != null) {

            if (node0 != null) {
                if (!seen.contains(node0)) {
                    seen.add(node0);
                    node0 = node0.parent;
                } else {
                    return node0;
                }
            }

            if (node1 != null) {
                if (!seen.contains(node1)) {
                    seen.add(node1);
                    node1 = node1.parent;
                } else {
                    return node1;
                }
            }
        }

        throw new IllegalArgumentException("node0 and node1 are not in the same tree");
    }

}
