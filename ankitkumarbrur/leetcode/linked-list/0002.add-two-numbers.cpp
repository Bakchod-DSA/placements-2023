// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/add-two-numbers/

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
        ListNode* dummy = new ListNode(0);
        ListNode* result = dummy;

        bool carry = false;
        while(l1 || l2 || carry) {
            // result for current decimal position
            int res = (l1 ? l1 -> val : 0)  // if 1st number is not exhausted get its value
                    + (l2 ? l2 -> val : 0)  // if 2nd number is not exhausted get its value
                    + (carry ? 1 : 0);      // if there is carry add it
            
            // store carry for next decimal value
            carry = res / 10;
            // result after removing carry
            res = res % 10;
            result -> next = new ListNode(res);
            result = result -> next;
            
            l1 = l1 ? l1-> next : nullptr;
            l2 = l2 ? l2-> next : nullptr;
        }

        return dummy -> next;
    }
};