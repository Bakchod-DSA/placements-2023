/**
 * Author : Sradha Kedia
 * Page no.: 275,276 of Epi Java
 * Problem no.: 15.11
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

public class Problem15_11_TestIfThreeBSTAreOrdered {
//
//    public static boolean
//    pairIncludesAncestorAndDescendantOfM(BstNode<Integer> possibleAncOrDesc0,
//                                         BstNode<Integer> possibleAncOrDesc1,
//                                         BstNode<Integer> middle) {
//
//        // return approachOne(possibleAncOrDesc0, possibleAncOrDesc1, middle);
//        return approachTwo(possibleAncOrDesc0, possibleAncOrDesc1, middle);
//    }
//
//    private static boolean approachOne(BstNode<Integer> possibleAncOrDesc0,
//                                       BstNode<Integer> possibleAncOrDesc1,
//                                       BstNode<Integer> middle) {
//    /*  Approach: Brute Force
//        Time Complexity: O(3h) worst case, O(2h) average
//        Space Complexity: O(h)
//    */
//
//        if(!possibleAncOrDesc0.data.equals(middle.data) && !middle.data.equals(possibleAncOrDesc1.data)) {
//            if (searchDescendant(possibleAncOrDesc0, middle)) {
//                return searchDescendant(middle, possibleAncOrDesc1);
//            } else if (searchDescendant(possibleAncOrDesc1, middle)) {
//                return searchDescendant(middle, possibleAncOrDesc0);
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean searchDescendant(BstNode<Integer> tree, BstNode<Integer> node) {
//        if(tree == null) {
//            return false;
//        }
//
//        if(tree.data.equals(node.data)) {
//            return true;
//        } else if(tree.data < node.data) {
//            return searchDescendant(tree.right, node);
//        } else {
//            return searchDescendant(tree.left, node);
//        }
//    }
//
//    private static boolean approachTwo(BstNode<Integer> possibleAncOrDesc0,
//                                       BstNode<Integer> possibleAncOrDesc1,
//                                       BstNode<Integer> middle) {
//    /*  Approach: Optimized
//        Time Complexity: O(2h)
//        Space Complexity: O(h)
//    */
//
//        BstNode<Integer> search0 = possibleAncOrDesc0;
//        BstNode<Integer> search1 = possibleAncOrDesc1;
//        while(search0 != possibleAncOrDesc1 && search0 != middle
//                && search1 != possibleAncOrDesc0 && search1 != middle
//                && (search0 != null || search1 != null)) {
//            if(search0 != null) {
//                search0 = (search0.data < middle.data)? search0.right : search0.left;
//            }
//            if(search1 != null) {
//                search1 = (search1.data < middle.data) ? search1.right : search1.left;
//            }
//        }
//
//        if(search0 == possibleAncOrDesc1 || search1 == possibleAncOrDesc0 || ((search0 != middle && search1 != middle))) {
//            return false;
//        }
//        if(search0 == middle) {
//            return searchDescendant(middle, possibleAncOrDesc1);
//        } else {
//            return searchDescendant(middle, possibleAncOrDesc0);
//        }
//    }
}
