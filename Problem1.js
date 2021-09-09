// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : While adding the path to the result my values were overriding

var result, path, target
var pathSum = function (root, targetSum) {
    result = [];
    path = [];
    target = targetSum;
    if (!root) return result;
    helper(root, 0, []);
    return result;
};

var helper = function (root, currSum) {
    // base
    if (!root) return;

    //logic
    path.push(root.val);
    currSum += root.val;
    if (!root.left && !root.right && currSum === target) {
        result.push(path.slice());
        // console.log(result);
    }

    //recursion
    helper(root.left, currSum);
    helper(root.right, currSum);

    //backtracking
    path.pop();
}