package codingBlocks;

import java.util.ArrayList;
import java.util.List;

public class MazePathDiagonal {
    public static void main(String[] args) {
        System.out.println(mazePathDiagonal(1, 1, 3, 3));
    }
    private static ArrayList<String> mazePathDiagonal(int cr, int cc, int er, int ec) {
        if (cr == er && cc == ec) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        if (cr > er || cc > ec) {
            ArrayList<String> baseResult = new ArrayList<>();
            return baseResult;
        }
        ArrayList<String> myResult = new ArrayList<>();
        ArrayList<String> rowResult = mazePathDiagonal(cr + 1, cc, er, ec);
        for (String rrs : rowResult) {
            myResult.add("H" + rrs);
        }
        ArrayList<String> colResult = mazePathDiagonal(cr, cc + 1, er, ec);
        for (String crs : colResult) {
            myResult.add("V" + crs);
        }
        ArrayList<String> diagResult = mazePathDiagonal(cr + 1, cc + 1, er, ec);
        for (String drs : diagResult) {
            myResult.add("D" + drs);
        }
        return myResult;
    }
}
