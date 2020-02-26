// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, trees are still hard for me.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
let result;
var pathSum = function(root, sum) {
    result = []; 
    helper(root, sum, []);
    return result;
};

var helper = function(root, sum, path) {
    // Base Case
    if (root == null) return null;
    if (root.left == null && root.right == null) {
        if (sum - root.val == 0) result.push([...path, root.val]);
        else return null;
    }
    // Logic
    if (root.left) helper(root.left, sum - root.val, [...path, root.val]);
    if (root.right) helper(root.right, sum - root.val, [...path, root.val]);
}
