import java.util.*;

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
    /* 
        TC - O(n)
        SC - O(n)
        We use BFS for this solution (level-order traversal with a queue).

        We start by adding the root twice into a queue to compare the tree with itself in a mirrored way.
        In each step, two nodes (t1 and t2) are taken from the queue and compared:
        If both are null, continue (they match). If only one is null, or their values are different, the tree is not symmetric.
        If values match, their children are added and compared in the following order :-
        t1.left with t2.right
        t1.right with t2.left
        This ensures we always compare opposite sides of the tree. If all pairs match, the tree is symmetric.
    */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}