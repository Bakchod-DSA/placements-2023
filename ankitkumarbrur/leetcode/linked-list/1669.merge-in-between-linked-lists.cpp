// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/merge-in-between-linked-lists/

// Time  Complexity: O(n+m)
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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* firstPrev = list1;
        ListNode* secondPrev = list1;
        
        while(--a) firstPrev = firstPrev -> next;
        while(b--) secondPrev = secondPrev -> next;
        
        firstPrev -> next = list2;
        
        while(firstPrev -> next) firstPrev = firstPrev -> next;
        
        firstPrev -> next = secondPrev -> next;
        
        return list1;
    }
};