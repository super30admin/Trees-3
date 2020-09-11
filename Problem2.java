Time Complexity: O(n)
Space Complexity: O(n)
Ran successfully on leetcode?: yes

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // return helper(root.left, root.right);
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root.left);
        st.add(root.right);
        
        while(!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            st.add(left.left);
            st.add(right.right);
            st.add(left.right);
            st.add(right.left);
        }
        return true;
    }
}
