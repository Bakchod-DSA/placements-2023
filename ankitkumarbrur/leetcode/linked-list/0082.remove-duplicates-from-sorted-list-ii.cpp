// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

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
        ListNode* dummy = new ListNode(0, head);
        
        ListNode* prev = dummy;
        ListNode* curr = head;
        
        while(curr) {
            if(curr -> next && curr -> val == curr -> next -> val) {
                while(curr -> next && curr -> val == curr -> next -> val) {
                    curr = curr -> next;
                }
                prev -> next = curr -> next;
            } else {
                prev = curr;
            }
            curr = curr -> next;            
        }
        
        return dummy -> next;
    }
};