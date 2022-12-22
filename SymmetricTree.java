//TC : o(n)
//SC : o(h) (recursive stack space)
//https://leetcode.com/problems/symmetric-tree/
//dfs
class Solution {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root.left,root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        //logic
        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }
        
        if(flag)
            dfs(left.left, right.right);
        if(flag)
            dfs(left.right, right.left);
    }
}
//bfs
class Solution {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right ==null) continue;
            if(left ==null || right == null || left.val != right.val){
                return false;
            }
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
        }
        return true;
    }
    
}
