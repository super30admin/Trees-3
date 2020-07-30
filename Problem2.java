// Time Complexity :O(n)
//      n: number of nodes
// Space Complexity :O(1)
//      we are just traversing and not couting Recursion Stack
//      Other wise O(h) -> height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
class Probelem2 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** find if tree is Symmetric */
    public boolean isSymmetric(TreeNode root) {
        // base case
        if(root==null)
            return true;
        // check left-sub tree == right-sub tree
        return helper(root.left, root.right);
    }
    
    /** helper function */
    private boolean helper(TreeNode left, TreeNode right){

        // base case
        if(left==null && right==null)
            return true;
        // either nodes is null or have different values
        if(left==null || right==null || left.val!=right.val)
            return false;
        // check left, right and right, left of the two reference
        else
            return helper(left.left, right.right) && helper(left.right, right.left);
    }
}