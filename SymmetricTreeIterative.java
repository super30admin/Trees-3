/*
Approach:
1. Use a queue to store pairs of nodes that should be mirror images of each other.
2. For each pair, check that both are null or their values are equal; otherwise return false.
3. Add (left.left, right.right) and (left.right, right.left) to the queue and continue until it is empty.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.*;

class SymmetricTreeIterative {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // Both are null
            if (left == null && right == null) {
                continue;
            }

            // One is null or values don't match
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // Compare mirror positions
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}

