// Time Complexity :O(n), n=number of nodes
// Space Complexity :O(h), h=height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class CheckSymmetric {


    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        //if root is null
        if(root==null) return true;
        //call helper function
        helper(root.left, root.right);
        return res;
    }

    public void helper(TreeNode left, TreeNode right){
        //if both node is null
        if(left==null && right==null) {
            return;
        }
        //if one of the node is null or value of nodes are not same
        if(left==null||right==null || left.val != right.val) {
            //update result
            res = false;
            return;
        }
        //if result is true
        if(res) {helper(left.left, right.right);}
        if(res){helper(left.right, right.left);}

        return ;
    }

}