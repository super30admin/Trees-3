// Time Complexity :  O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this :No





class Solution {

    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;

        return isMirror(root.left, root.right);

    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {

    if (t1 == null && t2 == null) return true;

    if (t1 == null || t2 == null) return false;

    return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);

}

}
