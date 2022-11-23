//Time complexity is O(N) 
//Space complexity is O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode one, TreeNode two){
        if(one==null && two == null){
            return true;
        }
        if((one==null && two!=null) || (one!=null && two ==null)){
            return false;
        }
        if(one.val!=two.val){
            return false;
        }
        return helper(one.left, two.right) && helper(one.right, two.left);
    }
}