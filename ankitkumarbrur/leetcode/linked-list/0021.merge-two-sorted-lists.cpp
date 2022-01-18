// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/merge-two-sorted-lists/

// Time  Complexity: O(n+m)
// Space Complexity: O(1)

// Solution 1: iterative
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* head = new ListNode(0);
        
        ListNode* curr = head;
        while(list1 != nullptr && list2 != nullptr) {
            if(list1 -> val > list2 -> val) {
                curr -> next = list2;
                list2 = list2 -> next;
            } else {
                curr -> next = list1;
                list1 = list1 -> next;
            }
            curr = curr -> next;
        }
        if(list1) curr -> next = list1;
        if(list2) curr -> next = list2;
        
        return head -> next;
    }
};

// Time  Complexity: O(n+m)
// Space Complexity: O(n|m)
// Solution 2 : recursive
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(!list1) return list2;
        if(!list2) return list1;
        
        if(list1 -> val > list2 -> val) {
            return new ListNode(list2 -> val, mergeTwoLists(list1, list2 -> next));
        } else {
            return new ListNode(list1 -> val, mergeTwoLists(list1 -> next, list2));
        }
    }
};