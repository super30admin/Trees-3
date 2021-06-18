// Time Complexity : O(N) where N is the number of nodes of the smaller subtree
// Space Complexity : O(H=N) height of the smaller subtree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode root1, TreeNode root2){
        //base
        if(root1 == null && root2 == null)
            return true;
        
        else if(root1 == null || root2 == null)
            return false;
            
        else if(root1.val != root2.val)
            return false;
        //logic
        else{
            boolean case1 = helper(root1.left, root2.right);
            boolean case2 = helper(root1.right, root2.left);
            return case1&&case2;
        }
        
    }
    
}

