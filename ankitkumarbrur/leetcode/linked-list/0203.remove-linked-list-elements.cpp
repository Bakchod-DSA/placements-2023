// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/remove-linked-list-elements/

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
    ListNode* removeElements(ListNode* head, int val) {
        while(head && head -> val == val) head = head -> next;

        ListNode* prev = nullptr;
        ListNode* curr = head;
        
        while(curr != nullptr) {
            if(curr -> val == val) {
                prev -> next = curr -> next;
            } else {
                prev = curr;
            }
            curr = curr -> next;
        }
        return head;
    }
};