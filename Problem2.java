// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //Here, we have to reucrisively check if left sub tree is equal to right sub tree. We use a helper function with parameters leftNode and rightNode.
    //We recursively check if leftNode's right child and rightNode's left child are equal or not. We also check if leftNode's left child and rightNode's right child are equal or not as well.
    //In every call, we check if the node values are equal or not. If one of the node turn's out null, we check if the other node is null or not. If both leftNode and rightNode are null, we return true to the parent call, otherwise we return false.
    
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
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode)
    {
        if (leftNode==null && rightNode==null)
        {
            return true;
        }
        else if (leftNode==null || rightNode==null)
        {
            return false;
        }
        else if (leftNode.val != rightNode.val)
        {
            return false;
        }
        else 
        {
            return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
        }
    }
}