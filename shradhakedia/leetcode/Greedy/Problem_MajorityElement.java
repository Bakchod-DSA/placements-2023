// https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
package leetcode.Greedy;

public class Problem_MajorityElement {
    static int majorityElement(int a[], int size)
    {
        int ele = -1, count = 0;
        for(int num : a) {
            if(count == 0) {
                ele =  num;
                count++;
            } else if(ele == num) {
                count++;
            } else {
                count--;
            }
        }


        count = 0;
        for(int num : a) {
            if(num == ele) {
                count++;
            }
        }

        return (count > size/2)? ele : -1;
    }
}
