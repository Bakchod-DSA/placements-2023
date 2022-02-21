package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/delete-and-earn/
 * Difficulty level : Medium
 */
public class problem740_DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int[] cache = new int[100001];

        for (int ele: nums) {
            cache[ele]++;
        }

        int prevKey = -1;
        int one = -1;
        int two = -1;

        for (int key = 0; key < cache.length; key++) if (cache[key] > 0) {

            int value = cache[key] * key;

            if (one == -1) {
                one = value;
            } else if (two == -1) {

                if (prevKey + 1 == key) {
                    two = Math.max(value, one);
                } else {
                    two = one + value;
                }
            } else {

                int curr = prevKey + 1 ==  key ? Math.max(two, one + value): two + value;
                one = two;
                two = curr;
            }
            prevKey = key;
        }
        return Math.max(one, two);
    }
}
