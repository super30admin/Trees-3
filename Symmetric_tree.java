// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        helper(root.left, root.right);
        return flag;
    }

    public void helper(TreeNode root1, TreeNode root2){
        if(root1 == null){
            if(root2 != null) flag = false; 
            return;
        }else if(root2 == null){
            if(root1 != null) flag = false;
            return;
        }
        if(root1.val != root2.val) flag = false;

        helper(root1.left, root2.right);
        helper(root1.right, root2.left);

    }
}
