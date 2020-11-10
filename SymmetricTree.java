/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Idea is to use recursion, code contains explanation.
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(n), worst case
 *  
 * Leetcode result:
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree. 
 * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Symmetric
 * Tree.
 */
class Solution {
    /**
     * 
     * @param root root node of the binary tree
     * @return true if it is symmetric, false otherwise
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    /**
     *          root                          root
     *         /    \                       /     \
     *     s.t.1    s.t.2                 x           y 
     *                                /     \      /     \
     *                            x.l.st  x.r.st  y.l.st  y.r.st
     * 
     *          fig 1                           fig 2
     * 
     * for tree in fig 1 to be symmetric, (s.t. subtree) s.t.1 and s.t.2 should be
     * symmetric for tree in fig 2 to be symmetric, x.val == y.val && x.l.st and
     * r.r.st should be symmetric and x.r.st and y.l.st should be symmetric.
     * 
     * @param nodeA
     * @param nodeB
     * @return true is sub tree rooted at nodeA and nodeB are symmetric, false otherwise
     */
    private boolean isSymmetric(TreeNode nodeA, TreeNode nodeB) {
        // base case
        if (nodeA == null && nodeB == null) {
            return true;
        }
        // if either if them is null, they aint symmetric
        if (nodeA == null || nodeB == null) {
            return false;
        }
        // from fig 2
        if (nodeA.val == nodeB.val && isSymmetric(nodeA.left, nodeB.right) && isSymmetric(nodeA.right, nodeB.left)) {
            return true;
        } else {
            return false;
        }
    }
}