// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. had to learn again

// Your code here along with comments explaining your approach

import java.util.*;

public class SymmetricTree {


    boolean flag;


    public boolean isSymmetric_dfsboolean(TreeNode root) {

        if(root == null ) return true;

        return dfs_boolean(root.left, root.right);
    }

    private boolean dfs_boolean(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left ==null || right==null || left.val != right.val){
            return false;
        }

        return dfs_boolean(left.left, right.right) && dfs_boolean(left.right, right.left);
    }



    //DFS with void based reccurssion 
    public boolean isSymmetric_dfsvoid(TreeNode root) {
        if(root ==null) return true;
        this.flag=true;

        dfs_void(root.left, root.right);
        return flag;
    }
    
    //With retrun as void
    private void dfs_void(TreeNode left, TreeNode right){
        if(left ==null && right==null) return;
        if(left ==null || right ==null || left.val != right.val){
            flag =false;
            return;
        }

        dfs_void(left.left, right.right);
        dfs_void(left.right, right.left);
    }

    // BFS approach
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        // Should i use while? or recursive or for? you have Queue.. check if its empty?
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            }

            else if (left.val != right.val) {
                return false;
            } else {
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }

        }

        return true;

    }

}