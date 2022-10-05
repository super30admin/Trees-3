// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Problem2 (https://leetcode.com/problems/symmetric-tree/)
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

let isValid = (left, right) => {
    // If both are null, it is valid
    if (left === null && right === null)
        return true;
    // If any one is null, it is invalid
    if (left === null || right === null)
        return false;

    // Checking if the values are same as well.
    return left.val === right.val && isValid(left.left, right.right) && isValid(left.right, right.left);

}
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function (root) {
    return isValid(root.left, root.right);
};