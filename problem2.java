    /**
    Time Complexity : O(N)
    Explanation:
    Each node is visited once while comparing symmetric pairs.

    Space Complexity : O(N)
    Explanation:
    Queue may store nodes level by level in worst case.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried comparing left and right subtrees separately,
    which became complex.
    Fixed it by pushing nodes in pairs into the queue:
        (left, right)
    and comparing them simultaneously to check mirror symmetry.
    */
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

        Queue<TreeNode> q = new LinkedList<>();

        // Add root twice to compare mirror
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            // Both null → symmetric
            if (t1 == null && t2 == null) continue;

            // One null or values differ → not symmetric
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // Add children in mirror order
            q.add(t1.left);
            q.add(t2.right);

            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }
}