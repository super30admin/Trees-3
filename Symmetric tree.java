// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//Using BFS: We will check the left and right value at each level and compare them. If at any point they are not same we return false. We add the left node in the queue and then the right node. This way the left.left and right.right and left.right and right.left values should be placed consequtively in the queue. Once the level is complete, the nodes are popped. If there is no dissimilarity till the end then we return true


class Solution {
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> Q=new LinkedList<>();
        Q.add(root.left);
        Q.add(root.right);
        
        while(!Q.isEmpty())
        {
            TreeNode left=Q.poll();
            TreeNode right=Q.poll();
            
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;

            Q.add(left.left);
            Q.add(right.right);
            Q.add(left.right);
            Q.add(right.left);

        }

return true;
    }
}


//Using DFS: We will a recursive function here. We will pass the left node and the right node in the DFS function and check if the left.left=right.right and left.right=right.left. 
//Void Based Recursion

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null) return true;
        this.flag=true; //default
        dfs(root.left,root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right)
    {
        //base
        if(left==null && right==null) return;
        //logic
        if(left==null || right==null || left.val!=right.val) 
        {
            flag=false;
            return;
        }

        if(flag)
        dfs(left.left,right.right);
        if(flag)
        dfs(left.right,right.left);
    }
}


//Using DFS: We will a recursive function here. We will pass the left node and the right node in the DFS function and check if the left.left=right.right and left.right=right.left. 
//Boolean Based Recursion

class Solution {
    
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null) return true;
        return dfs(root.left,root.right);
       
    }

    private boolean dfs(TreeNode left, TreeNode right)
    {
        //base
        if(left==null && right==null) return true;
        //logic
        if(left==null || right==null || left.val!=right.val) return false;
        return dfs(left.left,right.right) && dfs(left.right,right.left); 
    }
    
}