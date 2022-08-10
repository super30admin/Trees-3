// Time Complexity : O(n) where n in number of element in a tree
// Space Complexity : O(h) where h is height of a tree

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
 * @param {number} targetSum
 * @return {number[][]}
 */

let paths;
var pathSum = function (root, targetSum) {
  paths = [];
  inorder(root, targetSum, []);
  return paths;
};

var inorder = function (root, targetSum, path) {
  //base
  if (root === null) return;

  //action
  targetSum -= root.val;
  path.push(root.val);
  inorder(root.left, targetSum, [...path]);
  if (root.left === null && root.right === null && targetSum === 0) {
    paths.push(path);
  }
  inorder(root.right, targetSum, [...path]);
};
