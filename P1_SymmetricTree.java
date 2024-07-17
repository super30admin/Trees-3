//TC : O(n)
//SC : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()) {
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
}