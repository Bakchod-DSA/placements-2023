package EPI.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static EPI.Heap.Problem11_1_MergeSortedFiles.MergeKSortedArrays;

public class Problem11_2_SortAnIncreasingDecreasingArray {

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {

        List<List<Integer>> sortedArrays = new ArrayList<>();
        int type = 0; // 0 -> increasing, 1 -> decreasing
        int startIdx = 0;

        for(int i = 1; i <= A.size(); i++) {

            if(i == A.size() || (A.get(i - 1) < A.get(i) && type == 1) || (A.get(i - 1) >= A.get(i) && type == 0)) {
                List<Integer> subList = A.subList(startIdx, i);
                if (type == 1) {
                    Collections.reverse(subList);
                }
                sortedArrays.add(subList);
                startIdx = i;

                type = (type == 0)? 1 : 0;
            }
        }

        return MergeKSortedArrays(sortedArrays);
    }

}
