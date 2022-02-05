package codingBlocks;

import java.util.ArrayList;
import java.util.List;

public class GetBoardPath {
    public static void main(String[] args) {
        System.out.println(getPaths(10, 0));
    }

    private static List<String> getPaths(int target, int currSum) {
        if (currSum >= target) {
            List<String> result = new ArrayList<>();
            if (currSum == target)
                result.add("");
            return result;
        }
        List<String> result = new ArrayList<>();
        for (int dice = 1; dice <= 6; dice++) {
            List<String> temp = new ArrayList<>(getPaths(target, currSum + dice));
            for (String str: temp) {
                result.add(dice + str);
            }
        }
        return result;
    }
}
