//Time Complexity O(n)
//Space Complexity O(h)
//Leetcode tested

import java.util.Stack;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        while (!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(left == null && right == null) continue;
            if(left== null || right == null || left.val!=right.val) return false;
            st.add(left.left);
            st.add(right.right);
            st.add(left.right);
            st.add(right.left);
        }
        return true;
    }
}
