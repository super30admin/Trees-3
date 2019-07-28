Time and Space is :O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(root.val==p.val ||root.val==q.val)
            return root; //it is the lowest common ancestor for itself
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right =lowestCommonAncestor(root.right,p,q);
        
        if(left == null) return right; //if node returns null that means value isnt found it must be on the other side
        if(right ==null) return left;
        return root; //The base node is kept sending further up!
        
    }
}
