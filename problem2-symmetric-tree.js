// https://leetcode.com/problems/symmetric-tree/
// runtime: O(n) n is number of elements
// space: O(maxdepth of tree) which is the stack size
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// none pretty straightforward

//// Your code here along with comments explaining your approach

// recurse left and right at each step, compare values at that step
//   if both null return true
//   if only 1 is null return false
//   if values aren't equal return false
//   else recurse left, right
var isSymmetric, treeNode;

treeNode = function(val, left = null, right = null) {
  return Object.assign(Object.create(treeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

isSymmetric = function(root) {
  var recurse;
  recurse = function(p1left, p2right) {
    if (p1left === null && p2right === null) {
      return true;
    }
    if (p1left === null || p2right === null || p1left.val !== p2right.val) {
      return false;
    }
    return recurse(p1left.left, p2right.right) && recurse(p1left.right, p2right.left);
  };
  if (root === null) {
    return true;
  }
  return recurse(root.left, root.right);
};

isSymmetric(treeNode(1, treeNode(2, treeNode(3), treeNode(4)), treeNode(2, treeNode(4), treeNode(3))));

//# sourceMappingURL=problem2-symmetric-tree.js.map
