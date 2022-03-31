/**
 * Author : Sradha Kedia
 * Page no.: 173 of Epi Java
 * Problem no.: 10.17
 * Difficulty level : Medium
 */

package EPI.Tree.BinaryTree;

public class Problem10_17_ImplementLockingInABT {

    public static class BinaryTreeNode {
        private BinaryTreeNode left, right, parent;
        private int numberOfLockedDescendents = 0;
        private boolean locked = false;

        public boolean isLocked() {
            return locked;
        }

        public boolean lock() {
            // if any of the descendants is locked
            if(numberOfLockedDescendents > 0) {
                return false;
            }

            // if any of the ancestors is locked
            for (BinaryTreeNode iter = parent; iter != null; iter = iter.parent) {
                if(iter.isLocked()) {
                    return false;
                }
            }

            // already locked
            if(isLocked()) return false;

            // lock this node and increment the count of locked descendents for all its ancestors.
            locked = true;
            for (BinaryTreeNode iter = parent; iter != null; iter = iter.parent) {
                iter.numberOfLockedDescendents++;
            }
            return true;
        }

        public boolean unlock() {
            if(!isLocked()) return false;

            locked = false;
            for(BinaryTreeNode iter = parent; iter != null; iter = iter.parent) {
                iter.numberOfLockedDescendents--;
                iter = iter.parent;
            }

            return true;
        }
    }
}
