// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class Solution {
    Queue<TreeNode> qL = new LinkedList<>();
    Queue<TreeNode> qR = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;

        qL.offer(root.left);
        qR.offer(root.right);

        while(!qL.isEmpty() && !qR.isEmpty()){ 
            if(qL.size() != qR.size()) return false;

            TreeNode left = qL.poll();
            TreeNode right = qR.poll();

            if((left == null && right != null) || (right == null && left != null)) return false;
            else if(left == null && right == null) continue;

            if(left.val != right.val) return false;

            qL.offer(left.left);
            qL.offer(left.right);
            qR.offer(right.right);
            qR.offer(right.left);
        }

        return qL.size() == qR.size();

    }
}
