// ## Problem2 (https://leetcode.com/problems/symmetric-tree/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : I was thinking this was a invert binary tree pattern, but turns out this was 2 header patterns from isValid tree or subTree of a tree pattern
var isSymmetric = function(root) {
    // Time Complexity : O(N)
// Space Complexity : O(h)
    if(!root)return true
    function checkMirror(p,q){
        if(!p && !q) return true
        if(!p || !q) return false
        if(p.val != q.val) return false
        return checkMirror(p.left,q.right) && checkMirror(p.right,q.left)

    }
    return checkMirror(root.left,root.right)
};