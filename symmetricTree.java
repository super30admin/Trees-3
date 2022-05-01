//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        //initially we set the binary tree as valid
        isValid=true;
        //call the dfs method
        dfs(root.left, root.right);
        
        return isValid;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left==null&&right==null)
            return;
        if(left==null || right==null || left.val!=right.val){
            isValid=false;
            return;
        }
        //checking the left and right subtrees
        dfs(left.left, right.right);
        dfs(left.right, right.left);  
    }
}