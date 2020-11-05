// Time Complexity : O(n), where n is the number of nodes in the tree (exactly it is n/2 node traverals. Asymptomatically O(n))
// Space Complexity :O(n), where n is the number of nodes in the tree (size of recursive stack, in the worst case if skwed tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. We can do inorder traversal, From the root  start traversing the left and the right subtrees together
//2. return false if value of the left root and right root are not same OR the left root is null OR right root is null
//3. Keep comparing left's left node with right's node AND left's right node with right's left node, Till you reach the end of the tree

// Your code here along with comments explaining your approach

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
        if(root == null ) return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left ==null && right==null) return true;
        
        //logic
        //return false if
        //left OR right is null
        //left's value is not equal to right's value
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        
        //return false if any of the traversals are false
        if( helper(left.left, right.right) == false) return false;
        return  helper(left.right, right.left);
    }
}