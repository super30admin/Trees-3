import java.util.Stack;

//TC O(N)
// SC O(h) - where h is height of tree
public class SymmetricIterative {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while (!st.isEmpty()) {
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if (left == null && right == null)
                continue;
            if (left == null && right != null)
                return false;
            if (left != null && right == null)
                return false;
            if (left.val != right.val)
                return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
}
