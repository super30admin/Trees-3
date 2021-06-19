//time complexity:O(n)
//space complexity:O(1)
class Solution {
    public boolean isSymmetric(TreeNode root) {
         if(root==null)
         {
             return true;
         }
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left, TreeNode right)
    {
        if(left==null || right ==null)
        {
            return left==right; //we check whether the left ot right subtree is null
            //we return true if they are symmetric
        }
        if(left.val!=right.val)
        {
            return false;//if the values arent equal we return false
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
        // we check the left and right subtree's subtrees whether they are symmetric or not
    }
}
