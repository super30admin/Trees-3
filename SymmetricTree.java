// Overall Time Complexity : O(n) since we visit each node once.
// Overall Space Complexity : O(n) for the recursive stack space (worst-case).
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// Recursively check the left subtree and the right subtree
// Keep a flag to check if there is value mismatch between the nodes in the left subtree and right subtree
// Base cases are handled using the flag


import javax.swing.tree.TreeNode;

    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }
        dfs(root.left, root.right);
        return flag;
    }
    public void dfs(TreeNode left, TreeNode right){
        //base
        if(!flag) return;

        if(left == null && right ==null) return;
        
        //logic
        if(left ==null || right==null || left.val!=right.val){
            flag = false;
            return ;
        }
        //recurse
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
