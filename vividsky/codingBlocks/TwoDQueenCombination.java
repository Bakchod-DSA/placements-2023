package codingBlocks;

public class TwoDQueenCombination {

    public static void main(String[] args) {
        boolean[][] boxes = new boolean[4][3];
        twoDQueenCombination(0, 0,  boxes, 2, 0, "");
    }

    /**
     * This problem is with respect of Queens, i.e. where we can place different queens
     * */
    private static void twoDQueenCombination(int sRow, int sCol, boolean[][] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }
        for (int i = sRow; i < boxes.length; i++) {
            if (!boxes[i][sCol]) {
                boxes[i][sCol] = true;
                twoDQueenCombination(sRow + 1, sCol, boxes, tq, qpsf + 1, ans + " Q" +
                        qpsf + "B" + i + "B" + sCol + " ");
                boxes[i][sCol] = false;
            }
            for (int j = sCol + 1; j < boxes[0].length; j++) {
                if (!boxes[i][j]) {
                    boxes[i][j] = true;
                    twoDQueenCombination(sRow, sCol + 1, boxes, tq, qpsf + 1, ans + " Q" +
                            qpsf + "B" + i + "B" + j + " ");
                    boxes[i][j] = false;
                }
            }

        }
    }
    /**
     * This problem is with respect of Boxes, i.e. which different positions of box we can place queens
     * */
    private static void twoDQueenCombinationWRTBox(int row, int col, boolean[][] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

//        if (col == boxes[0].length) {
//            row++;
//            col = 0;
//        }
//        if (row == boxes.length) return;

        if (row == boxes.length) {
            return;
        }
        if (col == boxes[0].length) {
            twoDQueenCombinationWRTBox(row + 1, 0, boxes, tq, qpsf, ans );
            return;
        }
        boxes[row][col] = true;
        twoDQueenCombinationWRTBox(row, col + 1, boxes, tq, qpsf + 1, ans  + row + col + " ");
        boxes[row][col] = false;
        twoDQueenCombinationWRTBox(row, col + 1, boxes, tq, qpsf, ans);
    }
}
