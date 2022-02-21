package codingBlocks;

public class TwoDQueenCombinationKill {

    public static void main(String[] args) {
        boolean[][] boxes = new boolean[4][3];
        twoDQueenCombinationWRTBoxKill(0, 0,  boxes, 2, 0, "");
    }

    private static void twoDQueenCombinationWRTBoxKill(int row, int col, boolean[][] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

        if (col == boxes[0].length) {
            row--;
            col = 0;
        }

        if (row == boxes.length) {
            return;
        }

        if (isItSafeToPlaceQueen(boxes, row, col)) {
            boxes[row][col] = true;
            twoDQueenCombinationWRTBoxKill(row, col + 1, boxes, tq, qpsf + 1, ans  + row + col + " ");
            boxes[row][col] = false;
        }
        twoDQueenCombinationWRTBoxKill(row, col + 1, boxes, tq, qpsf, ans);
    }

    private static boolean isItSafeToPlaceQueen(boolean[][] boxes, int row, int col) {
        int r = row;
        int c = col - 1;
        while (c >= 0) {
            if (boxes[r][c]) {
                return false;
            }
            c--;
        }

        r = row - 1;
        c = col;
        while (r >= 0) {
            if (boxes[r][c]) {
                return false;
            }
            r--;
        }

        r = row - 1;
        c = col - 1;
        while (c >= 0 && r >= 0) {
            if (boxes[r][c]) {
                return false;
            }
            c--;
            r--;
        }

        r = row - 1;
        c = col + 1;
        while (r >= 0&& c < boxes[0].length) {
            if (boxes[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
