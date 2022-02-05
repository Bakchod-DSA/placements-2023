/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/pascals-triangle-ii/
 * Difficulty level: Easy
 */

package leetcode.Recursion;

import java.util.*;

public class Problem119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        return approachOne(rowIndex);
    }

    private List<Integer> approachOne(int n) {
        /*  Approach: Recursion
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(n == 0) {
            List<Integer> baseList = new ArrayList();
            baseList.add(1);
            return baseList;
        }
        if(n == 1) {
            List<Integer> baseList = new ArrayList();
            baseList.add(1);
            baseList.add(1);
            return baseList;
        }

        List<Integer> recurList = approachOne(n - 1);
        List<Integer> myList = new ArrayList();
        myList.add(1);
        for(int i = 0; i < recurList.size() - 1; i++) {
            myList.add(recurList.get(i) + recurList.get(i + 1));
        }
        myList.add(1);

        return myList;

    }

}
