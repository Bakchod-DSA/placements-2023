// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/next-greater-node-in-linked-list/

// Time  Complexity: O(n)
// Space Complexity: O(n)

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
    vector<int> nextLargerNodes(ListNode* head) {
        vector<int> v;
        stack<int> s;
        
        while(head) {
            while(!s.empty() && v[s.top()] < head -> val) {
                v[s.top()] = head -> val;
                s.pop();
            }
            s.push(v.size());
            v.push_back(head -> val);
            head = head -> next;
        }
        while(!s.empty()) v[s.top()] = 0, s.pop();
        return v;
    }
};