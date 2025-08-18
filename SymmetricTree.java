// Time Complexity : O(n) — each node is enqueued/dequeued once
// Space Complexity : O(h) avg, O(n) worst — queues hold up to a level of nodes
// Did this code successfully run on LeetCode : Yes
//
// approach:
// 1) If root is null, return true.
// 2) Use two queues to traverse left and right subtrees in lockstep (mirror order).
// 3) At each step, compare node values; enqueue children in mirrored order.


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        leftQueue.add(root.left);
        rightQueue.add(root.right);

        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();

            if(leftNode == null && rightNode == null) continue;
            else if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;

            leftQueue.add(leftNode.left);
            rightQueue.add(rightNode.right);
            leftQueue.add(leftNode.right);
            rightQueue.add(rightNode.left);
        }
        return true;
    }
}
