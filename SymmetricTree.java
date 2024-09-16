// Time Complexity : O(n) n= number of nodes in the tree 
// Space Complexity : O(h) h= height of tree
// Did this code successfully run on Leetcode : Yes


// Iterative Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.right);
        st.push(root.left);
        while(!st.isEmpty()) {
            TreeNode l = st.pop();
            TreeNode r = st.pop();
            if(l==null && r==null) { //leaf node
                continue;
            }
            if(l == null || r == null || l.val!=r.val) {
                return false;
            }
            st.push(l.left);
            st.push(r.right);
            st.push(l.right);
            st.push(r.left);
        }
        return true;
    }
}


// Recursive Solution

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode l, TreeNode r) {
        // base
        if(l == null || r == null) { // leaf node or when one of left or right nodes is absent
            return l==r;
        }
        if(l.val!=r.val) return false;
        return helper(l.left,r.right) && helper(l.right,r.left);
    }
    
}