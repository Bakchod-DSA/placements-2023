// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

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
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* temp = nullptr;
        
        temp = dummy;
        for(int i = 1; i < k; i++) temp = temp -> next;
        ListNode* firstPrev = temp;
        
        ListNode* slow = dummy;
        ListNode* fast = dummy;
        for(int i = 0; i <= k; i++) fast = fast -> next;
        while(fast) fast = fast -> next, slow = slow -> next;
        ListNode* secondPrev = slow;
        
        ListNode* first = firstPrev -> next;
        ListNode* second = secondPrev -> next;
        
        firstPrev -> next = second;
        secondPrev -> next = first;
        
        temp = first -> next;
        first -> next = second -> next;
        second -> next = temp;
        
        return dummy -> next;
    }
};