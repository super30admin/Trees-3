/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsSymmetric {
    boolean ans;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null ) return true;
        if(t1==null || t2==null) return false;
        boolean case1 = helper(t1.right, t2.left);
        boolean case2 = helper(t1.left, t2.right);
        return case1&&case2;
    }
}
