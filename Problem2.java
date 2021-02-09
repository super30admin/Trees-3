// Time Complexity :O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
//Adding the numbers twice in the queue so that we can check they are both equal.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if(a==null && b==null) continue;
            if(a==null || b==null) return false;
            if(a.val!=b.val) return false;
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
        }
        return true;
    }
}