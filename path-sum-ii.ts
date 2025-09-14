/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - O(n), n = number of nodes
// Space complexity - O(h), height of the tree
function pathSum(root: TreeNode | null, targetSum: number): number[][] {
	let result = [];
	helper(root, targetSum, 0, [], result);
	return result;
}

function helper(
	root: TreeNode | null,
	targetSum: number,
	curr: number,
	path: number[],
	result: number[][]
) {
	if (!root) return;

	curr += root.val;
	path.push(root.val);
	if (!root.left && !root.right) {
		if (curr === targetSum) result.push([...path]);
	}

	helper(root.left, targetSum, curr, path, result);
	helper(root.right, targetSum, curr, path, result);

	path.pop();
}
