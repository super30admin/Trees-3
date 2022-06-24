//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

//dfs iterative as we use Stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> q = new Stack<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.pop();
            TreeNode right = q.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            q.add(left.left);q.add(right.right);
            q.add(left.right);q.add(right.left);
        }
        return true;
    }
    
}

/*
//bfs iterative as we use Queue
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            q.add(left.left);q.add(right.right);
            q.add(left.right);q.add(right.left);
        }
        return true;
    }
    
}
*/

/*
//dfs with void
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }
        //
        dfs(left.left, right.right);
        if(flag)
            dfs(left.right, right.left);
    }
}
*/
/*
//dfs with return
class Solution {
    //boolean flag;
    public boolean isSymmetric(TreeNode root) {
        //flag = true;
        return dfs(root.left, root.right);
        //return flag;
    }
    private boolean dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        //
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
*/