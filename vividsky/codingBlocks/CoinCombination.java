package codingBlocks;

public class CoinCombination {
    public static void main(String[] args) {
        int[] coins = new int[] {2,3,5,6};
        System.out.println(coinCombinations(0, coins, 0, 10));
        coinCombinationsWRTCoins(0, coins, 0, 10,"");
    }

    private static ArrayList<String> coinCombinations(int idx, int[] coins, int currVal, int totalVal) {
        if (currVal == totalVal) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = idx; i < coins.length; i++) {
            if (currVal + coins[i] <= totalVal) {
                ArrayList<String> currCombinations = coinCombinations(i, coins, currVal + coins[i], totalVal);
                for (String currCombination : currCombinations) {
                    currCombination += coins[i];
                    result.add(currCombination);
                }
            }
        }
        return result;
    }

    private static void coinCombinationsWRTCoins(int idx, int[] coins, int currVal, int totalVal, String ans) {
        if (currVal == totalVal) {
            System.out.println(ans);
            return;
        }
        if (idx == coins.length) {
            return;
        }
        if (currVal + coins[idx] <= totalVal) {
            coinCombinationsWRTCoins(idx, coins, currVal + coins[idx], totalVal, ans + coins[idx]);
        }
        coinCombinationsWRTCoins(idx + 1, coins, currVal, totalVal, ans);
    }
}
