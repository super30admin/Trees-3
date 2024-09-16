// Time complexity - O(n)
// Space complexity - O(h)

// Iterative solution using Stack.

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
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root.right);
        st.push(root.left);
        
        while(!st.isEmpty()){
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            
            st.push(left.left);
            st.push(right.right);
            st.push(right.left);
            st.push(left.right);
        }
        return true;
    }
}
