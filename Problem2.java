// Time Complexity : O(n) - Iterating over each element of tree
// Space Complexity : O(n) - Using queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up to solution, had to see the solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Itertive solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(root);
        while(!que.isEmpty()){
            TreeNode t1 = que.poll();
            TreeNode t2 = que.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            que.add(t1.left);
            que.add(t2.right);
            que.add(t1.right);
            que.add(t2.left);
        }
        return true;
    }
}

// Recursive Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val) && helper(t1.left, t2.right) && helper(t1.right, t2.left);
        
    }
}


