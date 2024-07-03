// Time Complexity : O(n) => We are visiting n nodes
// Space Complexity : O(h) => Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Recursive approach where we check if either left or right child is missing return false. Otherwise perform left and recursive call by comparing mirror elements
 */
class Solution {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }

        isSymmetric = true;
        recurse(root.left, root.right);

        return isSymmetric;
    }

    private void recurse(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return;
        }

        //If either is null it indicates there is one mirror element missing
        if(left == null || right == null){
            isSymmetric = false;
            return;
        }

        if(left.val != right.val){
            isSymmetric = false;
            return;
        }

        recurse(left.left, right.right);
        recurse(left.right, right.left);

    }
}