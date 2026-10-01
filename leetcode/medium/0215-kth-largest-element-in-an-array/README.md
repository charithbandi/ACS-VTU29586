# Kth Largest Element in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `kth`  *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

 

 **Example 1:** 

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

```

 **Example 2:** 

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 93.58%)  
**Memory:** 75.9 MB (beats 28.40%)  
**Submitted:** 2026-10-01T03:59:45.035Z  

```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)