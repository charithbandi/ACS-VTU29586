# Lowest Common Ancestor of a Binary Search Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow  **a node to be a descendant of itself**).”

 

 **Example 1:** 

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

```

 **Example 2:** 

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

```

 **Example 3:** 

```
Input: root = [2,1], p = 2, q = 1
Output: 2

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [2, 105].
- -109 <= Node.val <= 109
- All Node.val are unique.
- p != q
- p and q will exist in the BST.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 97.13%)  
**Memory:** 46.9 MB (beats 99.44%)  
**Submitted:** 2026-10-01T03:52:45.815Z  

```java
class Solution {
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        TreeNode current = root;

        while (current != null) {

            // Both nodes are in the left subtree
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }

            // Both nodes are in the right subtree
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }

            // Nodes split around current,
            // or current is p or q
            else {
                return current;
            }
        }

        return null;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)