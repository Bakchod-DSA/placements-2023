package EPI.BinarySearch;

import java.util.List;

public class problem12_10_DuplicateAndMissing {
    public static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }
    }

    public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
        int n = A.size();
        int missXorDup = 0;

        for (int i = 0; i <n; i++) {
            missXorDup ^= i ^ A.get(i);
        }

        int msb = Integer.lowestOneBit(missXorDup);
        int missOrDup = 0;

        for (int i = 0; i < n; i++) {
            if ((msb & i) != 0) {
                missOrDup ^= i;
            }
            if ((msb & A.get(i)) != 0) {
                missOrDup ^= A.get(i);
            }
        }
        for (Integer i : A) {
            if (i == missOrDup) {
                return new DuplicateAndMissing(missOrDup, missOrDup ^ missXorDup);
            }
        }
        return new DuplicateAndMissing(missOrDup ^ missXorDup, missOrDup);
    }
}

