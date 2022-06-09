/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/count-inversions_615
 * Difficulty level: Medium
 */
package ExternalSources.Sorting;

public class Problem_CountInversions {
    static long count = 0;
    public static long getInversions(long arr[], int n) {
        mergeSort(arr, 0, n - 1);
        return count;
    }
    private static void mergeSort(long[] arr, int left, int right) {
        int mid;
        if(right > left) {
            mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(long[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 =  r - m;

        /* Create temp arrays */
        long a1[] = new long[n1];
        long a2[] = new long[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            a1[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            a2[j] = arr[m + 1 + j];

        int i , j;
        int k = l;
        for(i = 0, j = 0; i < n1 && j < n2;) {
            if(a1[i] > a2[j]) {
                arr[k++] = a2[j++];
                count += (n1 - i);
            } else {
                arr[k++] = a1[i++];
            }
        }

        while(j < n2) {
            arr[k++] = a2[j++];
        }
        while(i < n1) {
            arr[k++] = a1[i++];
        }
    }
}
