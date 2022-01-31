package EPI.BitManipulation;

class Divide {

    public static void main(String[] args) {
        System.out.println(divide(32, 9));
    }

    private static int divide(int i, int i1) {
        int quotient = 0;
        while (i > i1) {
            int y = msb(i, i1);
            i = i - (i1 << y);
            quotient += 1 << y ;
        }
        return quotient;
    }

    // to find max bit such that (i1 << bit) <= i
    private static int msb(int i, int i1) {

        int bit = 0;
        int low = 0;
        int high = 31;

        while(low <= high) {
            int mid = (low + high) / 2;
            if ((i1 << mid) <= i) {
                bit = low;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bit;
    }
}