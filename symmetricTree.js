// Time Complexity : O(n)
// Space Complexity : O(h) - worst case: O(n) if we come across a skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// DFS Approach
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

// Optimized BFS approach
var isSymmetric = function (root) {
  let isValid = true;
  if (!root) return isValid;
  const queue = [root.left, root.right];

  while (queue.length) {
    let rightRoot = queue.pop();
    let leftRoot = queue.pop();

    if (
      (leftRoot === null && rightRoot !== null) ||
      (rightRoot === null && leftRoot !== null) ||
      leftRoot?.val !== rightRoot?.val
    ) {
      isValid = false;
      return isValid;
    }
    if (leftRoot !== null && rightRoot !== null) {
      queue.push(leftRoot.left);
      queue.push(rightRoot.right);
      queue.push(leftRoot.right);
      queue.push(rightRoot.left);
    }
  }

  return isValid;
};

// BFS Approach - less optimized since we run a nested while loop
// and a for loop to check all elements found in the que
var isSymmetric = function (root) {
  let isValid = true;
  if (!root) return isValid;
  const queue = [root];

  while (queue.length) {
    let length = queue.length;
    while (length--) {
      root = queue.shift();
      root !== null && queue.push(root.left);
      root !== null && queue.push(root.right);
    }
    length = queue.length;
    for (i = 0; i < queue.length; i++) {
      if (
        (queue[i] === null && queue[length - 1 - i] !== null) ||
        (queue[length - 1 - i] === null && queue[i] !== null) ||
        (queue[i] !== null &&
          queue[length - 1 - i] !== null &&
          queue[i].val !== queue[length - 1 - i].val)
      ) {
        isValid = false;
      }
    }
  }
  return isValid;
};
