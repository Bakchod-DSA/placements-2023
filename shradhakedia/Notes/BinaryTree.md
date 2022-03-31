#Binary Tree

Binary Tree is a data structure of the form of a tree which consists of a node as the root and further its children 
left and right represented as nodes again.

- A node in a binary tree can have atmost two children.
- Types of traversals :
  1) Dfs
  2) Bfs
        

### DFS includes preorder, postorder, inorder and BFS includes level order.
- Preorder (root L R) : 
  1) Information flows downwards.
  2) Root to leaf computation.
  3) Direct tree to subtree computation.
- Postorder (L R root) :
  1) Information flows upwards.
  2) Leaf to root computation.
  3) Direct subtree to tree computation.
- Inorder (root L R) :
  1) Information flows from left to right.
  2) Leaf to root computation.
  3) Subtree computations first. 
- BFS (Level order traversal) :
  1) Information flows on the same level.


## Important data structures used in BT questions: 
1. Stack (e.g. dfs, whenever we need answer in reverse order)
2. Queue (e.g. bfs)
3. Linked List
4. Dequeue 

##Point to remember
A question on tree can be solved using anyone of these four traversals based on the requirement including the 
data structures suggested above. when approaching a question based on binary tree, firstly think which traversal will 
give me the answer and then use that template accordingly.

## Template for preorder traversal
    List<Integer> preorder = new ArrayList<>();
    private void approachOne(TreeNode root) {
        /*  Approach: dfs -> recursive approach
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root == null) {
            return;
        }
        preorder.add(root.val);
        // any computation required in the question
        approachOne(root.left);
        approachOne(root.right);
    }

    private List<Integer> approachTwo(TreeNode root) {
        /*  Approach: dfs -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);

                preorder.add(curr.val);
                // any computation required in the question
                
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            curr = temp.right;
        }

        return preorder;
    }


## Template for postorder traversal
    private List<Integer> approachOne(TreeNode root) {
        /*  Approach: dfs + stack -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null && (curr.left != null || curr.right != null)) {
                stack.push(curr);
                curr = curr.left;
            }

            if(curr != null) {
                // left and right node
                // computations required
                postorder.add(curr.val);
            }

            while(!stack.isEmpty() && curr == stack.peek().right) {
                // after adding left, right. we add root now
                curr = stack.pop();
                // computations required
                postorder.add(curr.val);
            }

            if(stack.isEmpty()) {
                curr = null;
            } else {
                // to add the right child we replace curr by right child
                curr = stack.peek().right;
            }

        }

        return postorder;
    }

    private void approachTwo(TreeNode root) {
        /*  Approach: dfs -> recursive approach
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root != null) {
            approachTwo(root.left);
            approachTwo(root.right);
            // computations required
            postorder.add(root.val);
        }
    }


## Template for inorder traversal
    private void approachOne(TreeNode root) {
    /*  Approach: dfs -> recursive approach
    Time Complexity: O(n)
    Space Complexity: O(h), height of the tree due to recursive stack
    */

        if(root == null) {
            return;
        }
        approachOne(root.left);
        // compuations required
        inorder.add(root.val);
        approachOne(root.right);
    }

    private void approachTwo(TreeNode root) {
        /*  Approach: dfs + stack -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            // computations required
            inorder.add(temp.val);
            curr = temp.right;
        }
    }

    private void approachThree(TreeNode root) {
        /*  Approach: morris Traversal
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                // computatons required
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode curr1 = curr.left;
                while(curr1.right != null) {
                    curr1 = curr1.right;
                }
                curr1.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;

            }
        }
    }


## Template for level order traversal
    private List<List<Integer>> bfs(TreeNode root) {
        /*  Approach: bfs + iteration
            Time Complexity: O(n)
            Space Copmplexity: O(n)
        */

        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelorder = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> singleLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                singleLevel.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            levelorder.add(singleLevel);
        }

        return levelorder;
    }