/**************** Time Complexity: O(n) ****************/
/**************** Space Complexity: O(1) ****************/

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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode tree1, TreeNode tree2){
        
        //if no node present
        if(tree1==null && tree2==null){
            return true;
        }
        
        //if single subtree is present (therefore not mirrorred)
        else if(tree1==null || tree2==null){
            return false;
        }
        
        //both left and right is present -> check if are mirror
        else{
            return tree1.val==tree2.val &&
                isMirror(tree1.left, tree2.right) &&
                isMirror(tree1.right, tree2.left);
        }
    }
}