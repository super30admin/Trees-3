// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// - Use a queue to perform a level-by-level BFS, enqueuing nodes in symmetric pairs.
// - For each step:
//   - Dequeue two nodes and compare them:
//     - If both are null, continue (they're symmetric).
//     - If only one is null or their values differ, the tree is not symmetric — return false.
// - Enqueue children in mirrored order to ensure symmetry is maintained in comparisons:
//   - Left child of the first node with right child of the second node.
//   - Right child of the first node with left child of the second node.
// - If all corresponding pairs match, the tree is symmetric — return true.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {

            TreeNode lnode = q.poll();
            TreeNode rnode = q.poll();


            if(lnode == null && rnode == null) continue;
            //If only one of them is null then they are not symmetric, return false
            if (lnode == null || rnode == null) return false;
            //Else check their values, if not same then they are not symmetric
            if (lnode.val != rnode.val) return false;

            //Enqueue in a manner that we can check symmetry if adj values in queue are same
            q.add(lnode.left);
            q.add(rnode.right);
            q.add(lnode.right);
            q.add(rnode.left);

        }
        return true;
    }
}