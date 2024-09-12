import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach
// Iterate through left and right sub trees at a time and check for the values if same.
public class SymmetricTree {
	//recursive
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null)return true;
    //     return helper(root.left, root.right);
    // }
    // public boolean helper(TreeNode left, TreeNode right){
    //     //base case
    //     if(left == null && right == null)return true;
    //     //check
    //     if(left == null || right == null || left.val != right.val) return false;
    //     //recurse
    //     return helper(left.left, right.right) && helper(left.right, right.left);
    // }
    //Iterative
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left); st.add(root.right);
        while(!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(left == null && right == null)continue;
            if(left == null || right == null || left.val != right.val) return false;
            st.add(left.left); st.add(right.right);
            st.add(left.right); st.add(right.left);
        }
        return true;
    }
}
