// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/merge-k-sorted-lists/

// Time  Complexity: O(Nlogk)
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
    ListNode* mergeLists(ListNode* left, ListNode* right) {
        ListNode* dummy = new ListNode(0, nullptr);
        
        ListNode* head = dummy;
        
        while(left && right) {
            if(left -> val < right -> val) {
                head -> next = left;
                left = left -> next;
            } else {
                head -> next = right;
                right = right -> next;
            }
            head = head -> next;
        }
        
        if(left) head -> next = left;
        else head -> next = right;
        
        return dummy -> next;
    }
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.empty()) return nullptr;
        int len = lists.size();
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) lists[i] = mergeLists(lists[i], lists[len - 1 - i]);
            len = (len + 1) / 2;
        }
        
        return lists.front();
    }
};