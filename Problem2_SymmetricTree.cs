// Time Complexity: O(n) n is the size of the tree
// Space Complexity: O(h) h is the height of the tree, which ranges from "log n" when tree is balanced to "n" when tree is asymmetric
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        return IsSymmetric(root.right, root.left);
    }
    
    public bool IsSymmetric(TreeNode actual, TreeNode image){
        if(actual == null && image == null) return true;
        
        if(actual == null || image == null || actual.val!=image.val) return false;
        
        return IsSymmetric(actual.left, image.right) &&
            IsSymmetric(actual.right, image.left);
    }
}