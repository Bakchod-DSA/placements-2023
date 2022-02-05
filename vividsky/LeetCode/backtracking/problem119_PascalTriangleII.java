package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/pascals-triangle-ii/
 * Difficulty level : Easy
 */
public class problem119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        return approachOne(rowIndex);
        // return approachTwo(rowIndex);
    }

    private List<Integer> approachOne(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            return currRow;
        }
        List<Integer> prevRow = approachOne(rowIndex - 1);
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        for (int i = 1; i < rowIndex; i++) {
            currRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        currRow.add(1);
        return currRow;
    }

    /**
     * In pascals triangle, nth row is represented as (n - 1)Cr where 0 <= r <= (n - 1)
     * */
    private List<Integer> approachTwo(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(findFactorial(rowIndex, i));
        }
        return result;
    }

    /**
     * This will return nCr
     * */
    private int findFactorial(int n, int r) {
        long res = 1;
        for (int i = 1; i <=r; i++) {
            res *= n - r + i;
            res /= i;
        }
        return (int)res;
    }
}
