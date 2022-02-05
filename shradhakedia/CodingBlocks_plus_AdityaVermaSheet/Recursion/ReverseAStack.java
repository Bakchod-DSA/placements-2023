/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9
 * Difficulty level : Medium
 */

package CodingBlocks_plus_AdityaVermaSheet.Recursion;

import java.util.Stack;

public class ReverseAStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(2);
        stack.add(5);
        stack.add(7);
        stack.add(4);

        System.out.println(stack);
        reverseAStack(stack, stack.size(), 0);
        System.out.println(stack);

    }

    private static void reverseAStack(Stack<Integer> stack, int size, int start) {
        if(start == size - 1) {
            return;
        }

        int curr = stack.pop();
        reverseAStack(stack, size, start + 1);
        addPeekAtBottomInReversedStack(stack, stack.size(), curr, 0);
    }

    private static void addPeekAtBottomInReversedStack(Stack<Integer> stack, int size, int element, int start) {
        if(start == size) {
            stack.push(element);
            return;
        }

        int curr = stack.pop();
        addPeekAtBottomInReversedStack(stack, size, element, start + 1);
        stack.push(curr);
    }
}
