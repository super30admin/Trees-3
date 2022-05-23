// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    if(!root){
        return true;
    }
    function symmetry(s,t){
        if(!s && !t){
            return true;
        }
        if(!s || !t || s.val !== t.val){
            return false;
        }
        return symmetry(s.left,t.right) && symmetry(s.right,t.left);
    }
    return symmetry(root.left,root.right);
    
    
};