// Time Complexity : O(n)
// Space Complexity : O(n) with the recursive stack, else O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//take two references from the root namely p1 and p2.
//p1 searches the left subtree and p2 goes for right subtree and compares in the runtime whether both are equal.
//if one of them is not equal or is null, return false else both of them are present and return true.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return recurr(root.left,root.right);

    }

    private boolean recurr(TreeNode p1, TreeNode p2){
        if(p1==null && p2==null){
            return true;
        }
        if(p1==null || p2==null || p1.val!=p2.val){
            return false;
        }
        return recurr(p1.left,p2.right) && recurr(p1.right,p2.left);
    }
}