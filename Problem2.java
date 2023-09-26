// Time Complexity : O(n) traverses through all nodes of tree
// Space Complexity : O(1) constant space not using any extra storage
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        boolean symmetric = false;
        boolean case1 = helper(left.left, right.right);
        if(left.val != right.val){
            return false;
        }
        boolean case2 = helper(left.right, right.left);

        return case1 && case2;
    }
}
