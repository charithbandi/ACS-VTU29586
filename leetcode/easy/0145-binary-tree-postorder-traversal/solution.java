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