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