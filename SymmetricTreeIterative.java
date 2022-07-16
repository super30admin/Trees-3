//Time complexity :O(n)
//Space Complexity:O(n)
//Facebook Interview
//There is iterative solution as well i.e. we can store the right child of right child of a node then left child of left child of a node and then right child of left child of a node and at last left child of right child of a node in the stack thenwe will be popping them and check if they are coming out to be equal or not till the time stack is not empty and in the end we can return the computed result accordingly.

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

        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(right == null && left == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}