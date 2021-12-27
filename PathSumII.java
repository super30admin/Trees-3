// Time Complexity : O(n)
// Space Complexity : O(h)

// Bottom up
public class PathSumII {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return dfs(root.left, root.right);
    }
    
    
    private boolean dfs(TreeNode left, TreeNode right)
    {
        // base
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
        {
            return false;
        }
        
        // logic
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
// DFS
public class PathSumII {
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return isSymmetric;
        dfs(root.left, root.right);
        return isSymmetric;
    }
    
    
    private void dfs(TreeNode left, TreeNode right)
    {
        // base
        if(left == null && right == null)
            return;
        if(left == null || right == null || left.val != right.val)
        {
            isSymmetric = false;
            return ;
        }
        
        // logic
        if(isSymmetric)
            dfs(left.left, right.right);
        if(isSymmetric) // minor optimization
            dfs(left.right, right.left);

    }
}

// Iterative BFS
public class PathSumII {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        
        while(!q.isEmpty())
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left == null && right == null)
                continue; // in lower levels there can be more nodes and we need to evaluate all pairs on that level
            
            if(left == null || right == null || left.val != right.val)
                return false;
            
            // add nodes for next level
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}
