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
 * @return {boolean}
 */
// var isSymmetric = function(root) {
//    if(!root) return false;
//    var helper = function(left, right) {
//        if(!left && !right) return true;
//        if(!left || !right || left.val != right.val) {
//            return false;
//        }
//        return helper(left.left, right.right) && helper(left.right, right.left)
//    }
//    return helper(root.left, root.right)
// };

var isSymmetric = function (root) {
  if (!root) return true;

  let stack = [];

  stack.push(root.left);
  stack.push(root.right);

  while (stack.length != 0) {
    let right = stack.pop();
    let left = stack.pop();
    if (!left && !right) continue;
    if (!left || !right || left.val != right.val) return false;
    stack.push(left.left);
    stack.push(right.right);
    stack.push(left.right);
    stack.push(right.left);
  }

  return true;
};
