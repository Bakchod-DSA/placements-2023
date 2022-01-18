// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* curr = head;
        
        while(curr) {
            while(curr -> next && curr -> val == curr -> next -> val)
                curr -> next = curr -> next -> next;
            curr = curr -> next;
        }
        
        return head;
    }
};