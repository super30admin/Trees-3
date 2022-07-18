//Time Complexity : O(n), where n is the no. of nodes
//Space Complexity : O(h), where h is the height of the tree
//Code run successfully on LeetCode.

public class Problem2_DFS {
	
    Boolean isSym = true;
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        
        helper(root.left, root.right);
        return isSym;
    }
    
    private void helper(TreeNode left, TreeNode right){
        
        if(left == null && right == null)
            return;
        
        else if(left == null || right == null || left.val != right.val)
        {
            isSym = false;
            return;
        }
        
        helper(left.left, right.right);
        helper(left.right, right.left);
         
    }

}
