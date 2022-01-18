// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* fast = dummy;
        ListNode* slow = dummy;
        
        // move fast n times from dummy
        while(n--) fast = fast -> next;
        
        // if fast is on last node stop there
        // slow pointer have reached on prev node of nth last node
        while(fast && fast -> next) {
            fast = fast -> next;
            slow = slow -> next;
        }
        
        slow -> next = slow -> next -> next;

        return dummy -> next;
    }
};