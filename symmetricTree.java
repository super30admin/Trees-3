package Trees3;

/*Source Link: https://leetcode.com/problems/symmetric-tree/
    Time complexity : o(n)
    space complexity: o(1) 
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class symmetricTree {
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;

        helper(root.left,root.right);

        return isValid;

    }

    private void helper(TreeNode leftNode, TreeNode rightNode) {

        if(leftNode == null && rightNode == null) return ;

        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val)
        {
            isValid = false;
            return;
        }

        helper(leftNode.left,rightNode.right);
        helper(leftNode.right,rightNode.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
