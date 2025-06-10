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
 // helper function recursively compares the left and right subtrees — ensuring the left subtree of one side matches the right subtree of the other and vice versa. If all corresponding nodes match in value and structure, the tree is symmetric.
 //Time complexity: O(n)
 //Space complexity: O(n)
class Solution {

    public boolean check(TreeNode l, TreeNode r)
    {
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;

        if((l.val==r.val) && check(l.left,r.right) && check(l.right,r.left))
            return true;

        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;  //empty tree
        return check(root.left, root.right);
    }
}