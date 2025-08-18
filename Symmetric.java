//approach-we are recursiving checking that values of childs on each side  i.e left val of left sub tree is equal to right values of right subtree and right val of left sub tree is equal to left val of right subtree.
//time complexity -> O(n) as we are visiting each node once.
//space complexity=O(h), h-> the most we would have each time in the recursive stack which is the height of the tree.
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
        var rL=root.left;
        var rR=root.right;
       return helper(rL,rR);
    }
    private boolean helper(TreeNode r1,TreeNode r2){
        if(r1!=null && r2==null)return false;
        if(r2!=null && r1==null)return false;
        if(r1==null && r2==null)return true;
        return (r1.val==r2.val)&&(helper(r1.left,r2.right)&&helper(r1.right,r2.left));
    }
}
