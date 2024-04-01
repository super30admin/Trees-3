/*
Approach 1: DFS 
TC: O(n)
SC: O(h)
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        boolean flag;
        if(root == null) return true;
        return(dfs(root.left, root.right));
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return dfs(left.left , right.right) && dfs(left.right, right.left);
    }

}

/*
Approach2: BFS
TC: O(n)
SC: O(n)
where n is number of elements
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val!=right.val ) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}