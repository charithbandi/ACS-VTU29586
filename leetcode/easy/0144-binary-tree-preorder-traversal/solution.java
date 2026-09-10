import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: empty tree
        if (root == null) {
            return result;
        }
        
        // Use Deque as stack
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);  // Visit root first
            
            // Push right child FIRST, then left
            // So left gets popped first (LIFO behavior)
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
}