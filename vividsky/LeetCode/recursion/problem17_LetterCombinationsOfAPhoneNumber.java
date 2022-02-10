package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Difficulty level : Medium
 */
public class problem17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.equals("")) return result;

        String[] arr = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();

        combinations(result, arr, digits, sb, 0);

        return result;
    }

    private void combinations(List<String> result, String[] arr, String digits, StringBuilder sb, int idx) {

        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = arr[digits.charAt(idx) - '0'];

        for (char i : letters.toCharArray()) {
            int len = sb.length();
            sb.append(i);
            combinations(result, arr, digits, sb, idx + 1);
            sb.setLength(len);
        }
    }
}
