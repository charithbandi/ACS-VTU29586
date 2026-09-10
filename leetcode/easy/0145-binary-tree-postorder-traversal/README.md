# Binary Tree Postorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `root` of a binary tree, return  *the postorder traversal of its nodes' values*.

 

 **Example 1:** 

 **Input:**  root = [1,null,2,3]

 **Output:**  [3,2,1]

 **Explanation:** 

 **Example 2:** 

 **Input:**  root = [1,2,3,4,5,null,8,null,null,6,7,9]

 **Output:**  [4,6,7,5,2,9,8,3,1]

 **Explanation:** 

 **Example 3:** 

 **Input:**  root = []

 **Output:**  []

 **Example 4:** 

 **Input:**  root = [1]

 **Output:**  [1]

 

 **Constraints:** 

- The number of the nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

 

 **Follow up:**  Recursive solution is trivial, could you do it iteratively?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 11.85%)  
**Memory:** 43.3 MB (beats 33.13%)  
**Submitted:** 2026-09-10T04:02:18.606Z  

```java
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            } else {
                curr = stack.pop().left;
            }
        }
        
        Collections.reverse(result);
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/)