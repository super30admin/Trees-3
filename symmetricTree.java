// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class TreeNode {
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
}

class Main {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        // queue for BFS
        Queue<TreeNode> q = new LinkedList();
        // first add left and right child of the root node
        q.add(root.left);
        q.add(root.right);
        // BFS traversl
        while (!q.isEmpty()) {
            // extracting 2 nodes from the queue.
            // as it is coming in the pair we are also removing in the pair
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // as we are also inserting null nodes in the queue we are skipping further code
            // if there is null that means we are not going to add child of the null in
            // queue
            if (left == null && right == null)
                continue;
            // at particular level if one of the node is null that means breach of condition
            // so we return false also we check left.val and right.val are not equal than
            // also we return false;
            if (left == null || right == null || left.val != right.val)
                return false;
            // add left.left and right.right first in the queue
            q.add(left.left);
            q.add(right.right);
            // then add left.right and right.left in the queue.
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}