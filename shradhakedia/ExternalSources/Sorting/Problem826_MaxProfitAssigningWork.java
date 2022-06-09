/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/most-profit-assigning-work/
 * Difficulty level: Medium
 */
package ExternalSources.Sorting;

import java.util.*;

public class Problem826_MaxProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;

        int n = worker.length;
        List<Pair> profitToDifficulty = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Pair pair = new Pair(profit[i], difficulty[i]);
            profitToDifficulty.add(pair);
        }

        Collections.sort(profitToDifficulty, (p1, p2) -> p2.profit - p1.profit);
        int[] worker1 = Arrays.stream(worker)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        for(int i = 0, j = 0; i < n && j < n;) {
            if(profitToDifficulty.get(j).difficulty <= worker1[i]) {
                maxProfit += profitToDifficulty.get(j).profit;
                i++;
            } else {
                j++;
            }
        }

        return maxProfit;
    }

    class Pair {
        int profit;
        int difficulty;
        Pair(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }
}
