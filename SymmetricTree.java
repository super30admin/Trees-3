// Time Complexity : O(n)
// Space Complexity : OO(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we will have a switch that will trigger if the tree is not symmetric
//we will recursively go through the tree and check if the outer nodes are the same and if the inner
//nodes are the same. If they are not we change the switch to false

public class Symmetric Tree {

    //switch
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        helper(root.left, root.right);

        return isValid;

    }

    public void helper(TreeNode left, TreeNode right){

        //if leaf node
        if(left == null && right == null) return;

        //if the values dont equal
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }

        //compare inner and outer nodes
        helper(left.left, right.right);
        helper(left.right, right.left);


    }
}