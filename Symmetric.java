//BFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(n), there will be n/2 nodes in the queue at leaf level
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Insert nodes in pair and after removing them check if they are equal or not.

/**
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
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i+=2){
                TreeNode l = q.poll();
                TreeNode r = q.poll();
                if(l == null && r == null) continue;
                if(l == null || r == null || l.val != r.val) return false;
                
                q.add(l.left);
                q.add(r.right);
                q.add(l.right);
                q.add(r.left);
            }
        }
        return true;
    }
}

//DFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(h), recursive stack 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : move dfs from both the directions, one side should be mirror of other side. Left should be compared with right and right with left.

/**
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
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        dfs(root.left,root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }

        dfs(left.left,right.right);
        if(flag)
            dfs(left.right,right.left);
    }
}