// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/reverse-linked-list-ii/

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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* dummy = new ListNode(0, head);
        
        ListNode* prev = NULL;
        ListNode* curr = dummy;

        while (left-- && right--) {
            prev = curr;
            curr = curr -> next;
        }
        
        ListNode* startNode = curr;
        ListNode* nextNode = NULL;
        
        while (right-- >= 0) {
            nextNode = curr -> next;
            curr -> next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        startNode -> next -> next = prev;
        startNode -> next = curr;
        
        return dummy -> next;
    }
};