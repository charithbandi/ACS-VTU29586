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
