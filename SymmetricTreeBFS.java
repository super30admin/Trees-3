// Time complexity: O(N)
// Space complexity: O(N)

// Approach: A tree is symmetric if the left subtree is a mirror reflection of the right subtree. What we do is we add both the left and right child to the queue initially. Then we pop the left and right child,return false if either is null or value does not match. We continue if both are null and finally we add 4 things to the queue, left.left, right.right, left.right and right.left.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}