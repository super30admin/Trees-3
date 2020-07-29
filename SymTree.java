
/*
// Time Complexity :O(n) + O(n) for both mirror and non mirror tree's
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //comming up with thought process to walk both tree's
    //simultaneously.
// Your code here along with comments explaining your approach

  this is a recursive solution.

*/
class Solution {
    private boolean walk(TreeNode lTree, TreeNode rTree){
        if(lTree == null && rTree == null)
            return true;
        /*
        else if((lTree == null && rTree != null) ||
            (lTree != null && rTree == null))
            return false;
        same as below statement.
        */
        else if(lTree == null || rTree == null)
            return false;

        if(lTree.val != rTree.val)
            return false;

        //walk left, mirror right
        if(!walk(lTree.left, rTree.right))
            return false;

        //walk right, mirror left
        if(!walk(lTree.right, rTree.left))
            return false;

        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return walk(root, root);
    }
}
