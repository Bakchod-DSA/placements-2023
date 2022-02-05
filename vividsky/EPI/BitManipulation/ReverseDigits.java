package EPI.BitManipulation;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(-234));
    }

    public static int reverseDigits(int i) {
        int reverse = 0;

        while(i != 0) {
            reverse = (reverse * 10) + (i%10);
            i/=10;
        }
        return reverse;
    }
}
