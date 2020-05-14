// Time Complexity : O(n) where n = total nodes in the tree
// Space Complexity : O(n) where n=number of nodes of the path from root to leaf node
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        
        Stack<Pair> st = new Stack<>();
        Pair p = new Pair(root.left,root.right);
        st.push(p);
        
        while(!st.isEmpty()){
            Pair tmpPair = st.pop();
            TreeNode left = tmpPair.getLeft();
            TreeNode right = tmpPair.getRight();
            
            if(left==null && right==null)
                continue;
            if(left==null || right==null || left.val!=right.val)
                return false;
            tmpPair = new Pair(left.left,right.right);
            st.push(tmpPair);
            
            tmpPair = new Pair(left.right,right.left);
            st.push(tmpPair);
        }
        return true;
    }
}

// Time Complexity : O(n) where n = total nodes in the tree
// Space Complexity : O(n) where n=number of nodes of the path from root to leaf node
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        
        if(left.val!=right.val)
            return false;
        
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
