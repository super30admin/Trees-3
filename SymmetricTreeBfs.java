//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: Looking closely at the examples, we see that the elements to the left and to the right of the tree should be the mirror image of each other
//Taking that into consideration, if we move beyond the 2nd level, we figure that left.left = right.right, left.right = right.left, else the tree is not symmetric
// if both left and right nodes are null, which means we are beyond the leaf node, continue processing other elements in the queue
//This can be done using BFS, DFS, but we will implement this using BFS using a Queue, it can be done using a Stack too
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeBfs {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            final TreeNode left = queue.poll();
            final TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        final SymmetricTreeBfs symmetricTreeBfs = new SymmetricTreeBfs();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        System.out.println(symmetricTreeBfs.isSymmetric(root)); //return true
        root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(symmetricTreeBfs.isSymmetric(root)); //return false
    }
}
