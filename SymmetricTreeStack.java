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
     
        // Time complexity : O(no.of nodes in the tree)
        // Space complexity : O(no of nodes / 2)
        
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null) return true;
        
        st.push(root.right);
        st.push(root.left);
        
        while(!st.isEmpty()) {
            
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            
            if(right == null && left == null) continue;
            
            if(right == null || left == null || right.val != left.val)
                return false;
            
            // Push 2 elements at a time, so they can popped as pairs and verified for validaity.
            
            st.push(right.right);
            st.push(left.left);
            
            st.push(right.left);
            st.push(left.right);
            
        }
        
        return true;
        
    }
}
