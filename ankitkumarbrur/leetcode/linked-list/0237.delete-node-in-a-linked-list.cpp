// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

// Time  Complexity: O(1)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        node -> val = node -> next -> val;
        node -> next = node -> next -> next;
    }
};