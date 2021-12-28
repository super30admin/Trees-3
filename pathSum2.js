// Time Complexity : O(n)
// Space Complexity : O(h) - worst case: O(n) if we come across a skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Optimized Approach: Instead of creating a new array and passing that in each time
// we call the dfs function, we now use the same array and pop stuff out as we unroll the stack.
// As for pushing an array to the results array, we send a copy of the existing array so that the
// array that is referenced can become empty at the end once the stack becomes empty.
var pathSum = function (root, targetSum) {
  if (!root) return [];
  const resultsArr = [];

  const dfs = (root, cSum, valArr) => {
    // base condition
    if (root === null) return;

    // logic
    valArr.push(root.val);
    cSum = cSum + root.val;
    dfs(root.left, cSum, valArr);
    dfs(root.right, cSum, valArr);
    if (root.left === null && root.right === null) {
      if (cSum === targetSum) {
        resultsArr.push([...valArr]);
      }
    }
    valArr.pop();
  };

  dfs(root, 0, []);
  return resultsArr;
};

// Slower approach since we're utilizing a new array each time, instead of
// mutating the existing one. This will return an O(n)^2 for both TC & SC.
var pathSum = function (root, targetSum) {
  if (!root) return [];
  const resultsArr = [];

  const dfs = (root, cSum, valArr) => {
    // base condition
    if (root === null) return;

    // logic
    valArr.push(root.val);
    cSum = cSum + root.val;
    dfs(root.left, cSum, [...valArr]);
    dfs(root.right, cSum, [...valArr]);
    if (root.left === null && root.right === null) {
      if (cSum === targetSum) {
        resultsArr.push(valArr);
      }
    }
  };

  dfs(root, 0, []);
  return resultsArr;
};
