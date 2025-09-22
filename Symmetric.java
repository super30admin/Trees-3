//Time Complexity: O(N) where N is number of nodes in the tree as we are traversing all nodes once.
//Space Complexity: O(N) since in the worst case we will have N/2 nodes in the queue at any point of time (for a complete binary tree).
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * The idea is to do a simultaneous traversal of left and right subtrees and compare the nodes at each step.At each level we compare the left node of left subtree with right node of right subtree and right node of left subtree with left node of right subtree.If at any step the values are not equal we return false.
 * If both nodes passed to the helper function are null we must return true since we must consider null nodes also while determining symmetry.
 * If one of the nodes is null and the other is not we return false since they are not symmetric. If both nodes passed are not null and their values are not equal we return false.
 * If any of the recursive calls return false we return false.
 * If all the comparisons are successful we return true.
 */
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
class Symmetric {
    public boolean isSymmetric(TreeNode root) {

        boolean result=helper(root.left,root.right);
        return result;

    }
    private boolean helper(TreeNode left, TreeNode right)
    {
        if(left==null && right == null) return true;
        else if(left==null||right==null)return false;
        else if(left.val!=right.val)return false;

    
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }

}