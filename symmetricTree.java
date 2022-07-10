import java.util.*;

// Time Complexity :O(n) where n is the number of nodes
// Space Complexity :O(1) as we insert at max 4 nodes into the stack at once.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> st = new Stack();
        st.push(root.left);
        st.push(root.right);
        while (!st.isEmpty()) {
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            st.push(left.left);
            st.push(right.right);
            st.push(right.left);
            st.push(left.right);
        }
        return true;
    }

}