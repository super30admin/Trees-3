// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Problem1 (https://leetcode.com/problems/path-sum-ii/)

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
let target;
let result;
let path;
var dfs = (root, sum, path) => {
    // Base
    if (root === null)
        return;
    // Logic
    // If it is leaf node and the sum is same as target, add path to final result
    if (root.left === null && root.right === null) {
        sum += root.val;
        path.push(root.val);
        if (sum === target) {
            result.push(path);
        }
        return;
    }
    // We add the root's value to sum and in path
    sum += root.val;
    path.push(root.val);
    dfs(root.left, sum, Array.from(path));
    dfs(root.right, sum, Array.from(path));
    // We backtrack to the previous path
    path.pop();
}

/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function (root, targetSum) {
    if (root === null)
        return [];
    target = targetSum;
    result = [];
    path = []
    dfs(root, 0, path);
    return result;
};