// Problem statement: https://i.redd.it/biv6pvk4vc681.png
package leetcode.DP.SubSequences;

public class Problem_AmazonOA_CountSubSequencesWithNoSameBinaryAdjacents {
    public static void main(String[] args) {
        String s = "10111";
        int numWays = recursion(s, s.length() - 1, 3, '2');
        System.out.println(numWays);
    }

    private static int recursion(String s, int ind, int target, char last) {
        if(target == 0) return 1;
        if(ind == -1) return 0;

        int notPick = recursion(s, ind - 1, target, last);
        int pick = 0;
        if(last != s.charAt(ind)) pick = recursion(s, ind - 1, target - 1, s.charAt(ind));

        return pick + notPick;
    }
}
