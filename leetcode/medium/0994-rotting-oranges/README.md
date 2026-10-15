# Rotting Oranges

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` `grid` where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is  **4-directionally adjacent**  to a rotten orange becomes rotten.

Return  *the minimum number of minutes that must elapse until no cell has a fresh orange*. If  *this is impossible, return*  `-1`.

 

 **Example 1:** 

```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

```

 **Example 2:** 

```
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

```

 **Example 3:** 

```
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 86.39%)  
**Memory:** 43.8 MB (beats 95.00%)  
**Submitted:** 2026-10-15T03:46:21.113Z  

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 2)
                    q.add(new int[]{i,j});
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] k = q.poll();
                int r = k[0];
                int c = k[1];
                if (n > r + 1 && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    q.add(new int[]{r + 1,c});
                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    q.add(new int[]{r - 1,c});
                }   
                if (m > c + 1 && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    q.add(new int[]{r,c + 1});
                }   
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    q.add(new int[]{r, c - 1});
                }
            }
            ans += 1;
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return -1;
        return Math.max(0, ans - 1);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotting-oranges/)