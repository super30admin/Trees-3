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
    public boolean isSymmetric(TreeNode rootNode) {
        if(rootNode == null) return true;
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(rootNode.left);
        nodesQueue.offer(rootNode.right);
        
        while(!nodesQueue.isEmpty()){
            TreeNode leftChild = nodesQueue.poll();
            TreeNode rightChild = nodesQueue.poll();
            
            if(rightChild == null && leftChild == null) continue;
            if(leftChild == null || rightChild == null || leftChild.val != rightChild.val) return false;
            
            nodesQueue.offer(leftChild.left);
            nodesQueue.offer(rightChild.right);
            nodesQueue.offer(leftChild.right);
            nodesQueue.offer(rightChild.left);
        }
        return true;
    }
}
