import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // Using Breadth first search
        // TC - O(n)
        // SC - O(h)
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue <TreeNode> q = new LinkedList <>();
            // adding elements into the queue
            q.add(root.left);
            q.add(root.right);
            TreeNode left;
            TreeNode right;
            while (!q.isEmpty()) {
                // popping two elements out
                left = q.poll();
                right = q.poll();

                // if both are null, we will continue - because this doesn't break the condition of symmetric trees
                if (left == null && right == null) {
                    continue;
                }
                // if either of them is null, condition is broken
                else if (left == null || right == null) {
                    return false;
                } else {
                    // both are not null, then we will add the elements into the queue with correct elements
                    if (left.val != right.val) {
                        return false;
                    }
                    q.add(left.left);
                    q.add(right.right);
                    q.add(left.right);
                    q.add(right.left);
                }

            }
            return true;
        }

        boolean isValid;
        // Another way is DFS
        // TC - O(n)
        // SC - O(h) height of tree
        public boolean isSymmetric2(TreeNode root) {
            if (root == null) {
                return true;
            }
            isValid = true;
            isSymmetric2(root.left, root.right);
            return isValid;
        }

        public void isSymmetric2(TreeNode left, TreeNode right) {
            // base case
            // doesn't break the symmetric tree condition, hence isValid is not changed here
            if(left == null && right == null) {
                return;
            }

            // condition breaks for symmetric trees, so isValid is made false
            if(left == null || right == null || left.val!=right.val) {
                isValid = false;
            }

            // calling the child nodes recursively
            if(isValid) {
                isSymmetric2(left.left, right.right);
                isSymmetric2(left.right, right.left);
            }
        }
    }
}
