//time complexity O(n)
//space complexity O(w) where w is the max width of the queue

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode tLeft = q.poll();
            TreeNode tRight = q.poll();
            if(tLeft == null && tRight == null) continue;
            if(tLeft != null && tRight == null) return false;
            if(tLeft == null && tRight != null) return false;
            if(tLeft.val != tRight.val) return false;
            if(tLeft.val == tRight.val) {
                q.add(tLeft.left);
                q.add(tRight.right);
                q.add(tLeft.right);
                q.add(tRight.left);
            }
        }
        return true;
    }
}
