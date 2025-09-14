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
function isSymmetric(root: TreeNode | null): boolean {
	return helper(root, root);
}

function helper(t1: TreeNode | null, t2: TreeNode | null): boolean {
	if (!t1 && !t2) return true;

	if (!t1 || !t2) return false;

	return (
		t1.val === t2.val &&
		helper(t1.left, t2.right) &&
		helper(t1.right, t2.left)
	);
}
