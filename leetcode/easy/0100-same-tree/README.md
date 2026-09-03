# Same Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

 **Example 1:** 

```
Input: p = [1,2,3], q = [1,2,3]
Output: true

```

 **Example 2:** 

```
Input: p = [1,2], q = [1,null,2]
Output: false

```

 **Example 3:** 

```
Input: p = [1,2,1], q = [1,1,2]
Output: false

```

 

 **Constraints:** 

- The number of nodes in both trees is in the range [0, 100].
- -104 <= Node.val <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.1 MB (beats 15.63%)  
**Submitted:** 2026-09-03T05:52:05.712Z  

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/same-tree/)