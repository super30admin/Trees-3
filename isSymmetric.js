/**
 * @param {TreeNode} root
 * @return {boolean}
 *
 * Intuition:
 * A binary tree is symmetric if its left and right subtrees are mirror
 * images of each other.
 *
 * To verify this, we recursively compare two nodes at a time—one from
 * the left subtree and one from the right subtree.
 *
 * If both nodes are null, symmetry is preserved.
 * If only one node is null, the tree is not symmetric.
 * If both nodes exist, their values must be equal, and their children
 *   must also be mirror images of each other:
 *     - left child of one node with right child of the other
 *     - right child of one node with left child of the other
 *
 * By starting this comparison from the root’s left and right children,
 * we can determine whether the entire tree is symmetric.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
var isSymmetric = function (root) {

    const helper = (rootA, rootB) => {
        if (!rootA && !rootB) return true;
        if (!rootA || !rootB) return false;

        return (
            rootA.val === rootB.val &&
            helper(rootA.left, rootB.right) &&
            helper(rootA.right, rootB.left)
        );
    };

    return helper(root.left, root.right);
};
