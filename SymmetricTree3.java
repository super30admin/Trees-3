import java.util.LinkedList;
import java.util.Queue;

/**
 * SymmetricTree3 checks if a binary tree is symmetric around its center using an iterative approach.
 *
 * Approach:
 * - Uses a queue to perform a level-order traversal, comparing nodes in pairs.
 * - At each step, dequeues two nodes and checks if they are mirrors of each other.
 * - Enqueues children in the order that preserves symmetry checking.
 *
 * Time Complexity:
 * - O(N), where N is the number of nodes in the tree. Each node is enqueued and dequeued once.
 *
 * Space Complexity:
 * - O(H), where H is the maximum width of the tree (number of nodes at the largest level), due to the queue.
 */

public class SymmetricTree3 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null & right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.right);
            queue.add(right.left);
            queue.add(left.left);
            queue.add(right.right);
        }
        return true;
    }
}
