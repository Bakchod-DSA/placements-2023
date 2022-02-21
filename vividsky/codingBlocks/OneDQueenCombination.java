package codingBlocks;

public class OneDQueenCombination {
    public static void main(String[] args) {
        boolean[] boxes = new boolean[4];
        oneDQueenCombinationWRTQueen(0, boxes, 2, 0, "");
    }

    /**
     * This problem is with respect of Queens, i.e. where we can place different queens
     * */
    private static void oneDQueenCombinationWRTQueen(int start, boolean[] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }
        for (int i = start; i < boxes.length; i++) {
            if (boxes[i] == false) {
                boxes[i] = true;
                oneDQueenCombinationWRTQueen(start + 1, boxes, tq, qpsf + 1, ans + " Q" + qpsf + "B" + i + " ");
                boxes[i] = false;
            }
        }
    }

    /**
     * This problem is with respect of Boxes, i.e. which different positions of box we can place queens
     * */
    private static void oneDQueenCombinationWRTBox(int start, boolean[] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }
        if (start == boxes.length) {
            return;
        }
        boxes[start] = true;
        oneDQueenCombinationWRTBox(start + 1, boxes, tq, qpsf + 1, ans + "Q" + qpsf + "B" + start + " ");
        boxes[start] = false;
        oneDQueenCombinationWRTBox(start + 1, boxes, tq, qpsf, ans);
    }
}
