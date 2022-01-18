// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

// Time  Complexity: O(n)
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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* listA = headA;
        ListNode* listB = headB;
        
        while(listA != listB) {
            listA = !listA ? headB : listA -> next ;
            listB = !listB ? headA : listB -> next;
        }
        
        return listA;
    }
};