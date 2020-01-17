// S30 Big N Problem #47 {Easy}
// 101. Symmetric Tree
// Time Complexity :O(n) where is the number of nodes in the tree
// Space Complexity : O(2h)-> O(h){asymp} where h is the height of the binary tree stored in the stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// iterative approach
// putting values in dfs manner in a stack and checking the symmetricity by poping and checking two values
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
        if(root==null) return true;
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty()){
            TreeNode r1=stack.pop();
            TreeNode r2=stack.pop();
            if(r1==null && r2==null) continue; //further branches needs to be checked before returning value
            if(r1==null || r2==null || r1.val !=r2.val) return false;
            stack.push(r1.left);
            stack.push(r2.right);
            stack.push(r1.right);
            stack.push(r2.left);
        }
        
        return true;
        
    }
}