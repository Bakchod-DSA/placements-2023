package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * Difficulty level : Medium
 */
public class problem373_FindKPairsWithSmallestSums {

    /**
     Heap
     Time : O((M + N)logN) where N = nums1.length, M = nums2.length
     Space: O(N)
     Algo : initialise heap in ascending order of sums of pair elements
     Add all pairs with first elem of nums1 or first ele of nums2
     start polling peek element and add it in result as peek will contain pair with smallest sum
     nums1 = [1, 7, 11]
     nums2 = [2, 4, 6]

     result = []
     heap = [[1, 2], [1, 4], [1, 6]]

     result = [[1, 2]]
     heap = [[1, 4], [1, 6], [7, 2]] (why [7, 2]?? we have added [1, 2] in result, hence we will look for
     next pair with same nums2 ele)
     result = [[1, 2], [1, 4]]
     heap = [[1, 6], [7, 2], [7, 4]] and so on
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<ArrayEntry> heap = new PriorityQueue<>((e1, e2) -> e1.pair.get(0) + e1.pair.get(1) - e2.pair.get(0) - e2.pair.get(1));
        List<List<Integer>> result = new ArrayList<>();

        for (int p = 0; p < nums1.length; p++) {
            heap.add(new ArrayEntry(new ArrayList<>(Arrays.asList(nums1[p], nums2[0])), 0));
        }

        while (k-- > 0 && !heap.isEmpty()) {

            ArrayEntry entry = heap.poll();
            result.add(entry.pair);

            // To check whether length of nums2 has been exhausted or not, if yes then there is no new pair can be formed
            if (entry.j < nums2.length - 1) {
                heap.add(new ArrayEntry(new ArrayList<>(Arrays.asList(entry.pair.get(0), nums2[entry.j + 1])), entry.j + 1));

            }
        }
        return result;
    }

    private class ArrayEntry{
        ArrayList<Integer> pair;
        int j;

        ArrayEntry(ArrayList<Integer> pair, int j) {
            this.pair = pair;
            this.j = j;
        }
    }
}
