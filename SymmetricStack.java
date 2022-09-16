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
//tc- o(n)
//sc-o(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        
        while(!st.isEmpty())
        {
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if(left==null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            st.add(left.left);
            st.add(right.right);
            st.add(left.right);
            st.add(right.left);
            
        }
        return true;
        
}
}