package CodingBlocks_plus_AdityaVermaSheet.Recursion;

import java.util.*;

public class GameOfDeath {

    public static void main(String[] args) {

        int n = 8;
        int k = 5;
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(findSafePosition(nums, k - 1));
        System.out.println(findSafePositionRecursively(nums, k - 1, 0));
    }

    private static int findSafePosition(List<Integer> nums, int k) {

        int i = 0;
        while (nums.size() > 1)  {
            i = (i + k) % nums.size();
            nums.remove(i);
        }

        return nums.get(0);
    }

    private static int findSafePositionRecursively(List<Integer> nums, int k, int i) {

        if(nums.size() == 1) {
            return nums.get(0);
        }

        if((i + k) < nums.size()) {
            nums.remove(i + k);
        }
        return findSafePositionRecursively(nums, k, (i + k) % nums.size());
    }
}
