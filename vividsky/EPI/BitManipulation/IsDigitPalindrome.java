public class IsDigitPalindrome {
    public static void main(String[] args) {
        System.out.println(isDigitPalindromeApproachTwo(-34));
    }

    private static boolean isDigitPalindrome(int i) {
        if (i < 0) return false;
        return i == ReverseDigits.reverseDigits(i);
    }

    private static boolean isDigitPalindromeApproachTwo(int num) {
        int x = 9;
        int y = x | (~(x + 1));
        System.out.println(y);
        if (num < 0) {
            return false;
        }
        int numDigits = (int)Math.floor(Math.log10(num)) + 1;
        int msdMask = (int) Math.pow(10, numDigits - 1);
        for (int i = 0; i < numDigits/2; i++) {
            if (num/msdMask != (num % 10)) {
                return false;
            }
            num = (num % msdMask)/10;
            msdMask/=100;
        }
        return true;

    }
}
