// Time Complexity : O(n) --> where n is total number of node in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (101): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        
        while (!st.isEmpty()) {
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }    
}