// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/add-two-numbers-ii/

// Time  Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {        
        int n = 0;
        int m = 0;
        ListNode* temp = l1;
        while(temp) temp = temp -> next, n++;
        temp = l2;
        while(temp) temp = temp -> next, m++;
        
        int frozen = abs(n - m);        
        if(n < m) {
            ListNode* t = l1;
            l1 = l2;
            l2 = t;
        }
        ListNode* result = nullptr;
        while(frozen--) {
            result = new ListNode(l1 -> val, result);
            l1 = l1 -> next;
        }
        while(l1 && l2) {
            result = new ListNode(l1 -> val + l2 -> val, result);
            l1 = l1 -> next;
            l2 = l2 -> next;
        }
        
        bool carry = false;
        ListNode* prev = nullptr;
        while(result) {
            result -> val += carry ? 1 : 0;
            carry = result -> val / 10;
            result -> val %= 10;
            
            ListNode* temp = result -> next;
            result -> next = prev;
            prev = result;
            result = temp;
        }
        if(carry) prev = new ListNode(1, prev);
        
        return prev;
    }
};