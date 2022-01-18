// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/odd-even-linked-list/

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
    ListNode* oddEvenList(ListNode* head) {
        if(head) {
            ListNode* evenHead = nullptr;
            evenHead = head -> next;
        
            ListNode* even = evenHead;
            ListNode* odd = head;

            while(odd && even && even -> next) {
                odd -> next = even -> next;
                even -> next = even -> next -> next;

                odd = odd -> next;
                even = even -> next;
            }

            odd -> next = evenHead;
        }
        return head;
    }
};