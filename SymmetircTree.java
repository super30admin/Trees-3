// Time Complexity : O(n)
// Space Complexity : O(h)  (h is the height of the tree)
// Did this code successfully run on Leetcode : Yes


package BST;

public class SymmetircTree {

    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        helper(root.left,root.right);
        return flag;

    }

    public void helper(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null)
        {
            flag = true;
            return;
        }
        if(node1 == null || node2 == null)
        {
            flag = false;
            return;
        }
        if(flag)
            if(node1.val != node2.val) flag = false;
        if(flag)
            helper(node1.left, node2.right);
        if(flag)
            helper(node1.right, node2.left);

    }
}
