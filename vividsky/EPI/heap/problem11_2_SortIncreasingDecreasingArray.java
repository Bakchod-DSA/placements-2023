package EPI.heap;

import java.util.*;

public class problem11_2_SortIncreasingDecreasingArray {

    /**
     * We are getting List of iterators from method createKsortedLists
     * Since no subarray is empty, we add first element as it is in heap,
     * then we keep polling from heap and adding it to our result
     * and if the iterator of the array to which the popped element belongs hasNext() element to0, we add it to our heap
     * */
    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<ArrayEntry> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        List<Iterator<Integer>> subArrays = createKSortedLists(A);
        for (int id = 0; id < subArrays.size(); id++) {
            heap.add(new ArrayEntry(subArrays.get(id).next(), id));
        }

        while (!heap.isEmpty()) {
            ArrayEntry arrayEntry = heap.poll();
            result.add(arrayEntry.value);
            if (subArrays.get(arrayEntry.arrayId).hasNext()) {
                heap.add(new ArrayEntry(subArrays.get(arrayEntry.arrayId).next(), arrayEntry.arrayId));
            }
        }
        return result;
    }

    private static class ArrayEntry {
        Integer value;
        Integer arrayId;

        ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    /**
     * Here we are creating sub-arrays that are all sorted the moment we are getting any critical point,
     * we save the subarray from start to curr index and update our start as curr index
     * since it is critical point, if initial sorting was increasing, we will change it as decreasing and vice versa
     * */
    private static List<Iterator<Integer>> createKSortedLists(List<Integer> A) {
        List<Iterator<Integer>> arrays = new ArrayList<>();
        int startIdx = 0;
        SubarrayType subarrayType = SubarrayType.INCREASING;
        for (int i = 1; i <= A.size(); i++) {
            if (i == A.size()
                    || A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING
                    || A.get(i - 1) > A.get(i) && subarrayType == SubarrayType.INCREASING) {
                List<Integer> arr = A.subList(startIdx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(arr);
                }
                arrays.add(arr.iterator());
                startIdx = i;
                subarrayType = subarrayType == SubarrayType.DECREASING ? SubarrayType.INCREASING : SubarrayType.DECREASING;
            }
        }
        return arrays;
    }

    /**
     * Enum for constants
     * */
    public enum SubarrayType {
        INCREASING,
        DECREASING
    }
}
