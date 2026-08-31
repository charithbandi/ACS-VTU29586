# Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` and an integer `limit`, return the size of the longest  **non-empty**  subarray such that the absolute difference between any two elements of this subarray is less than or equal to `limit` *.* 

 

 **Example 1:** 

```
Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.

```

 **Example 2:** 

```
Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

```

 **Example 3:** 

```
Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 109
- 0 <= limit <= 109

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 67.47%)  
**Memory:** 93.6 MB (beats 49.77%)  
**Submitted:** 2026-08-31T03:30:39.941Z  

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> decQ = new LinkedList<>();
        Deque<Integer> incQ = new LinkedList<>();
        int ans = 0;
        int left = 0;

        for (int right = 0; right < nums.length; ++right) {
            int num = nums[right];

            while (!decQ.isEmpty() && num > decQ.peekLast()) {
                decQ.pollLast();
            }
            decQ.addLast(num);

            while (!incQ.isEmpty() && num < incQ.peekLast()) {
                incQ.pollLast();
            }
            incQ.addLast(num);

            while (decQ.peekFirst() - incQ.peekFirst() > limit) {
                if (decQ.peekFirst() == nums[left]) {
                    decQ.pollFirst();
                }
                if (incQ.peekFirst() == nums[left]) {
                    incQ.pollFirst();
                }
                ++left;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)