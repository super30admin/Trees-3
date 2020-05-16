/**
Time Complexity: O(N) as we have to traverse all the node once in the array.
Space Complexity: O(N) as we will push all the nodes in the stack;
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
        if(root == null)return true;
        Stack<TreeNode>st = new Stack<>();
        st.push(root.right);
        st.push(root.left);
        while(!st.isEmpty())
        {
            TreeNode n1 = st.pop(), n2 = st.pop();
            if(n1==null && n2 == null)
                continue;
            if(n1 == null || n2 == null || n1.val != n2.val)
                return false;
            st.push(n1.right);
            st.push(n2.left);
            st.push(n1.left);
            st.push(n2.right);
        }
        return true;
    }
}