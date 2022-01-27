package EPI.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMsbOfANumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(findMsbOfANumber(n));
    }

    private static int findMsbOfANumber(int target) {
        int low = 0;
        int high = 30;

        while(low < high) {
            int mid = high - ((high - low) >> 1);
            if((1 << mid) <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
