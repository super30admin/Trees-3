// Time Complexity :O(n)// n is no. of nodes in the tree
// Space Complexity :O(N/2)-> O(N)asymptotically  where N/2 is the no. of children in the Tree
// Did this code successfully run on Leetcode 101 : yes
/*Approach : Symmetric means the values present in the left.left node should be equal to right.right at any level
and left.right should be equal to right.left*/


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
/*class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null||right==null||left.val!=right.val)
            return false;
        return helper(left.left,right.right)&& helper(left.right,right.left);
    }
}*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
    Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left=q.poll();
            TreeNode right=q.poll();
            if(left==null && right==null) continue;
             if(left==null||right==null||left.val!=right.val)
             return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

    return true;
    }
}

