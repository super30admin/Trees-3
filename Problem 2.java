// Time Complexity : O(n)
// Space Complexity : O(n) , in worst case the tree is skewed
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, the mirrorring logic was hard


// Your code here along with comments explaining your approach

/*
We will take left and right pointers to the root , and recurse

we will recuse one time with left's' right and right's' left 
&&
we will recurse another time with left's' left and right's' right
We will Take AND of the both of the result and return it
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //edge cases
        //helper call
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        // edge case
        if(left == null || right == null){
            return (left == null && right == null);
        }

        // base case

        if(left.val != right.val){
            return false;
        }

        // go lefts and rights

        return helper(left.right,right.left) && helper(left.left,right.right);

    }
}