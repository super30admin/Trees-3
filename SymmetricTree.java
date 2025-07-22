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
    boolean isSymmetric = true;
    // DFS - pass left and right to the dfs()
    public boolean isSymmetricDFS(TreeNode root) {
        if (root == null) {
            return true;
        }
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

    // BFS solution. Initially add both left and right into queue.
    // Poll left and right, check the conditions and add their children in the order of
    // how must be compared
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }
}