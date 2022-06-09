/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/pascals-triangle/
 * Difficulty level: Easy
 */
package leetcode.Array;

import java.util.*;

public class Problem118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        // return approachOne(numRows);
        return approachTwo(numRows);
    }

    private List<List<Integer>> approachOne(int numRows) {
        /*  Approach: Intuitive (Brute Force)
            Time Complexity: O(n * n)
            Space Complexity: O(1)
        */

        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return pascalTriangle;

        List<Integer> prevRow = new ArrayList<>(Arrays.asList(1, 1));
        pascalTriangle.add(prevRow);
        if(numRows == 2) return pascalTriangle;

        for(int i = 3; i <= numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for(int j = 1; j < prevRow.size(); j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            pascalTriangle.add(new ArrayList<>(currRow));
            prevRow = currRow;
        }

        return pascalTriangle;
    }

    private List<List<Integer>> approachTwo(int numRows) {
        /*  Approach: Math (Combinations)
            Time Complexity: O(n * n)
            Space Complexity: O(1)
        */
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return pascalTriangle;

        for(int i = 2; i  <= numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for(int j = 1; j < i; j++) {
                int n = i - 1;
                int prevEle = currRow.get(j - 1);
                int currEle = ((n - j + 1) * prevEle)/j;
                currRow.add(currEle);
            }
            pascalTriangle.add(new ArrayList<>(currRow));
        }
        return pascalTriangle;
    }
}
