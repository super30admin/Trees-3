// Time Complexity :O(n) where n is the number of nodes in the tree and in the worst case, we'll traverse all the nodes
// Space Complexity : O(1) as no auxiliary space used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
public class SymmetricTree {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        helper(root.left, root.right);
        return flag;
    }

    public void helper(TreeNode leftNode, TreeNode rightNode){
        if(!flag || (leftNode == null && rightNode == null)){
            return;
        }

        int leftRoot = leftNode != null ? leftNode.val : 101;
        int rightRoot = rightNode != null? rightNode.val: 101;
        if(leftRoot != rightRoot){
            flag = false;
            return;
        }

        helper(leftNode.left, rightNode.right);
        helper(leftNode.right, rightNode.left);
    }
}
