// Time Complexity : O(n)
// Space Complexity : O(h) - worst case: O(n) if we come across a skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

var isSymmetric = function (root) {
  let isValid = true;
  if (!root) return isValid;

  const dfs = (leftRoot, rightRoot) => {
    // Base
    if ((leftRoot === null && rightRoot === null) || !isValid) {
      return;
    }

    if (
      (leftRoot === null && rightRoot !== null) ||
      (rightRoot === null && leftRoot !== null) ||
      leftRoot.val !== rightRoot.val
    ) {
      isValid = false;
      return;
    }

    // Logic
    dfs(leftRoot.left, rightRoot.right);
    dfs(leftRoot.right, rightRoot.left);
  };

  dfs(root.left, root.right);
  return isValid;
};

// Alternate implementation approach where we return true or false via the function
// instead of updating a global variable's assignment
var isSymmetric = function (root) {
  if (!root) return true;

  const dfs = (leftRoot, rightRoot) => {
    // Base
    if (leftRoot === null && rightRoot === null) {
      return true;
    }

    if (
      (leftRoot === null && rightRoot !== null) ||
      (rightRoot === null && leftRoot !== null) ||
      leftRoot.val !== rightRoot.val
    ) {
      return false;
    }

    // Logic
    return (
      dfs(leftRoot.left, rightRoot.right) && dfs(leftRoot.right, rightRoot.left)
    );
  };

  return dfs(root.left, root.right);
};
