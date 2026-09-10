# Binary Tree Preorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `root` of a binary tree, return  *the preorder traversal of its nodes' values*.

 

 **Example 1:** 

 **Input:**  root = [1,null,2,3]

 **Output:**  [1,2,3]

 **Explanation:** 

 **Example 2:** 

 **Input:**  root = [1,2,3,4,5,null,8,null,null,6,7,9]

 **Output:**  [1,2,4,5,6,7,3,8,9]

 **Explanation:** 

 **Example 3:** 

 **Input:**  root = []

 **Output:**  []

 **Example 4:** 

 **Input:**  root = [1]

 **Output:**  [1]

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

 

 **Follow up:**  Recursive solution is trivial, could you do it iteratively?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43 MB (beats 70.04%)  
**Submitted:** 2026-09-10T03:38:24.040Z  

```java
import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: empty tree
        if (root == null) {
            return result;
        }
        
        // Use Deque as stack
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);  // Visit root first
            
            // Push right child FIRST, then left
            // So left gets popped first (LIFO behavior)
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-preorder-traversal/)