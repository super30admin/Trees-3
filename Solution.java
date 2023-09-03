//symmetric-tree
//TC:O(n)
//SC:queue size or max width of tree
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
        
       // LL implementation of queue
       //USe BFS
       if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>(); 
        //for the first node add its children in queue
        queue.add(root.left);
        queue.add(root.right);        

        while(!queue.isEmpty())
        {
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            //go to next set of nodes
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;
            //to check symmetric tree
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left); 

        }
        return true;
        
    }
}