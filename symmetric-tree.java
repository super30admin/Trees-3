// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

//Iterative
class Solution{
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        Stack<TreeNode> st=new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode right=st.pop();
            TreeNode left=st.pop();
            if(left == null && right==null){
                continue;
            }
            if(left==null || right==null || left.val!=right.val){
                return false;
            }
            st.add(left.left); st.add(right.right);
            st.add(left.right); st.add(right.left);
        }
        return true;
    }
}