/**
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;

        boolean verify = (leftNode.val == rightNode.val);
        boolean leftMirror = isMirror(leftNode.left, rightNode.right);
        boolean rightMirror = isMirror(leftNode.right, rightNode.left);

        return verify && leftMirror && rightMirror;

    }
}