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