/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://binarysearch.com/problems/Diagonal-Tree-Traversal
 * Difficulty level: Medium
 */
package ExternalSources.Tree;

import java.util.*;

class Tree {
     int val;
     Tree left;
     Tree right;
}

class Problem_DiagonalTreeTraversal {
    public int[] solve(Tree root) {
        List<Integer> diagSumList = dfs(root);
        int[] diagSumArr = new int[diagSumList.size()];
        for(int i = 0; i < diagSumList.size(); i++) {
            diagSumArr[i] = diagSumList.get(i);
        }
        return diagSumArr;
    }

    private List<Integer> dfs(Tree root) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.right == null && root.left == null) {
            return new ArrayList<>(Arrays.asList(root.val));
        }

        List<Integer> rt = dfs(root.right);
        List<Integer> lt = dfs(root.left);
        List<Integer> thisLevel = formDiagonalList(lt, rt, root);

        return thisLevel;

    }

    private List<Integer> formDiagonalList(List<Integer> lt, List<Integer> rt, Tree root) {
        List<Integer> thisLevel = new ArrayList<>();
        if(rt.isEmpty()) {
            thisLevel.add(root.val);
            thisLevel.addAll(lt);
        } else {
            thisLevel.add(root.val + rt.get(0));
            int i, j;
            for(i = 1, j = 0; i < rt.size() && j < lt.size(); i++, j++) {
                thisLevel.add(lt.get(j) + rt.get(i));
            }
            while(i < rt.size()) {
                thisLevel.add(rt.get(i));
                i++;
            }
            while(j < lt.size()) {
                thisLevel.add(lt.get(j));
                j++;
            }
        }

        return thisLevel;
    }
}
