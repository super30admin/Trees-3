// Time Complexity :O(n)
// Space Complexity :0(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class SymmetricTree {
    class TreeNode {
        int val;
        PathSumTwo.TreeNode left;
        PathSumTwo.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, PathSumTwo.TreeNode left, PathSumTwo.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;

        return (r1.val==r2.val)&&helper(r1.left,r2.right)&&helper(r1.right,r2.left);
    }
}
