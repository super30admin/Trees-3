/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 *
 * Intuition:
 * We use a Depth-First Search (DFS) approach because we need to explore
 * each root-to-leaf path completely before moving to another path.
 *
 * A helper function `dfs` traverses the tree while keeping track of the
 * current path and the running sum of node values along that path.
 *
 * When a leaf node is reached (a node with no left or right child),
 * we compare the accumulated sum with the target sum.
 * If they are equal, we add a copy of the current path to the result.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
var pathSum = function (root, targetSum) {
    const res = [];
    if (!root) return res;

    const dfs = (node, path = [], currSum = 0) => {
        if (!node) return;

        // include current node
        currSum += node.val;
        path.push(node.val);

        // check leaf node
        if (!node.left && !node.right) {
            if (currSum === targetSum) {
                res.push([...path]); // copy path to avoid mutation
            }
        }

        // explore children
        dfs(node.left, path, currSum);
        dfs(node.right, path, currSum);

        // backtrack
        path.pop();
    };

    dfs(root);
    return res;
};
