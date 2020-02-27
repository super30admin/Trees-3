/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Level Order Traversal and dfs Approach is used to compare 
class Solution {
    static boolean isRec = false;
    public boolean isSymmetric(TreeNode root) {
        if(!isRec){
            return mirror(root,root);
        }
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();;
            
            if(node1 != null && node2 != null){
                if(node1 == null || node2 == null || node1.val != node2.val)
                    return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
    
    public boolean  mirror(TreeNode p,TreeNode q){
        if(p == null& q == null)
            return true;
         if (p == null || q == null) return false;
        return p.val == q.val && mirror(p.left,q.right) && mirror(p.right,q.left);
    }
}