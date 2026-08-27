# Final Prices With a Special Discount in a Shop

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `prices` where `prices[i]` is the price of the `ith` item in a shop.

There is a special discount for items in the shop. If you buy the `ith` item, then you will receive a discount equivalent to `prices[j]` where `j` is the minimum index such that `j > i` and `prices[j] <= prices[i]`. Otherwise, you will not receive any discount at all.

Return an integer array `answer` where `answer[i]` is the final price you will pay for the `ith` item of the shop, considering the special discount.

 

 **Example 1:** 

```
Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation: 
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.

```

 **Example 2:** 

```
Input: prices = [1,2,3,4,5]
Output: [1,2,3,4,5]
Explanation: In this case, for all items, you will not receive any discount at all.

```

 **Example 3:** 

```
Input: prices = [10,1,1,6]
Output: [9,0,1,6]

```

 

 **Constraints:** 

- 1 <= prices.length <= 500
- 1 <= prices[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 60.60%)  
**Memory:** 45.1 MB (beats 86.69%)  
**Submitted:** 2026-08-27T03:54:06.442Z  

```java
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        // Stack to store indices of items
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Apply discount while top of stack is >= current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                prices[idx] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/)