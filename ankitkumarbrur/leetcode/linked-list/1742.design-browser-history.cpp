// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/design-browser-history/

class BrowserHistory {
    string url = "";
    BrowserHistory* next;
    BrowserHistory* prev;
    BrowserHistory* head;
    BrowserHistory* curr = nullptr;
public:
    BrowserHistory(string homepage, BrowserHistory* nextNode, BrowserHistory* prevNode): url(homepage), next(nextNode), prev(prevNode) {}
    BrowserHistory(string homepage) {
        head = new BrowserHistory(homepage, nullptr, nullptr);
        curr = head;
    }

    // Time  Complexity: O(1)
    // Space Complexity: O(1)
    void visit(string url) {
        curr -> next = new BrowserHistory(url, nullptr, curr);
        curr = curr -> next;
    }
    
    // Time  Complexity: O(k)
    // Space Complexity: O(1)
    string back(int steps) {
        while(steps-- && curr -> prev != nullptr) curr = curr -> prev;
        return curr -> url;
    }
    
    // Time  Complexity: O(k)
    // Space Complexity: O(1)
    string forward(int steps) {
        while(steps-- && curr -> next) curr = curr -> next;
        return curr -> url;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */