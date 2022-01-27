public class Power {
    public static void main(String[] args) {
        System.out.println(powerApproachTwo(3, 5));
    }

    private static double power(double x, int y) {
        if (y == 0) {
            return 1;
        }
        if ((y &1) != 1) {
            return power(x, y>>1) * power(x, y>>1);
        } else {
            return x * power(x, y - 1);
        }
    }
    private static double powerApproachTwo(double x, int y) {
        int result = 1;
        while (y > 0) {
            if ((y & 1) != 0) {
                result *= x;
            }
            x *= x;
            y >>= 1;
        }
        return result;
    }
}
