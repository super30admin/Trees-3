// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    TreeNode left;
    TreeNode right;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        left=null;
        right=null;
      return  helper(root.left,root.right);
    }
    private boolean helper(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null||root1.val!=root2.val) return false;
       // if(root.left==null && root.right==null) return true;
        //if(helper(root.left)==null) return false;
                
        if(helper(root1.left, root2.right) && helper(root1.right,root2.left)) return true;
       
         return false;
    }
}
