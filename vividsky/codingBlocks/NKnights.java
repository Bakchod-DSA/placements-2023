package codingBlocks;

public class NKnights {

    public static void main(String[] args) {
        nKnights(0, 0, new boolean[3][3], 3, 0, "");
    }
    private static void nKnights(int row, int col, boolean[][] boxes, int tq, int qpsf, String ans) {
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

        if (row == boxes.length) {
            return;
        }
        if (col == boxes[0].length) {
            nKnights(row + 1, 0, boxes, tq, qpsf, ans );
            return;
        }
        if (isItSafeToPlaceKnights(boxes, row, col)) {
            boxes[row][col] = true;
            nKnights(row, col + 1, boxes, tq, qpsf + 1, ans  + row + col + " ");
            boxes[row][col] = false;
        }

        nKnights(row, col + 1, boxes, tq, qpsf, ans);
    }

    private static boolean isItSafeToPlaceKnights(boolean[][] boxes, int row, int col) {
        if (row > 0 && col > 1 && boxes[row - 1][col - 2]) {
            return false;
        } else if (row > 0 && col < boxes[0].length - 2 && boxes[row - 1][col + 2]) {
            return false;
        } else if (row > 1 && col > 0 && boxes[row - 2][col - 1]) {
            return false;
        } else if (row > 1 && col < boxes.length - 1 && boxes[row - 2][col + 1]) {
            return false;
        }
        return true;
    }
}
