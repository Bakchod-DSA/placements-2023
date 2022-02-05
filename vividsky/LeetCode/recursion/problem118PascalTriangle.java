package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/pascals-triangle/
 * Difficulty level : Easy
 */
public class problem118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            result.add(currRow);
            return result;
        }
        List<List<Integer>> result = generate(numRows - 1);
        List<Integer> prevRow = result.get(result.size() - 1);
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            currRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        currRow.add(1);
        result.add(currRow);
        return result;
    }
}
