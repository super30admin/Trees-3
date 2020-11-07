// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var isSymmetric = function(root) {
    if(root == null) return true;
    return helper(root.left, root.right)

    function helper(left, right) {
        //base case
        if(left == null && right == null) return true
        //logic
        if(left == null || right == null || left.val != right.val) return false
        return helper(left.left, right.right) && helper(left.right, right.left)
    }
};