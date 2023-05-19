// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * DFS approach where we check values are matching are not.
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SymmetricTree {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;
    }
    private void dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return;
        }
        if(left == null || right == null) {
            isSymmetric = false;
            return;
        }
        if(left.val != right.val) {
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(n) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * Iterative approach where we check values are matching are not and push elements in the queue.
 */
class SymmetricTreeItr {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }  
}
