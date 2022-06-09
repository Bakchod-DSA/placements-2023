/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/flatten-nested-list-iterator/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem341_FlattenNestedListIterator {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer. Return null if this NestedInteger holds a nested list
        Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list. Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            buildStack(nestedList);
        }

        @Override
        public Integer next() {
            if(!hasNext()) {
                return null;
            }
            return stack.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                NestedInteger ni = stack.peekFirst();
                if(!ni.isInteger()) {
                    stack.removeFirst();
                    buildStack(ni.getList());
                } else {
                    break;
                }
            }
            return !stack.isEmpty();
        }

        private void buildStack(List<NestedInteger> nestedList) {
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.addFirst(nestedList.get(i));
            }
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
