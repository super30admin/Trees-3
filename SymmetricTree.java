// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we check the left of left and right of right. if they are equal then we check right of left and left of right.
//if the left and right is not equal we return false
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        flag= true;
        dfs(root.left,root.right);
        return flag;
    }
    private void dfs(TreeNode left,TreeNode right){
        if(left == null && right == null)return;
        if(left == null || right == null || left.val!=right.val){
            flag = false;
            return;
        }
        if(flag)dfs(left.left,right.right);
        if(flag)dfs(left.right,right.left);
    }
}

//bfs
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right==null)continue;
            if(left==null || right == null || left.val!=right.val){
                return false;
            }
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
        }
        return true;

    }
}
