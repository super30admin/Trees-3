// Problem1 - https://leetcode.com/problems/symmetric-tree/submissions/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class BFS {
            public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root.left);
            q.add(root.right);
            
            while(!q.isEmpty()){
                // int size = q.size();
                // for(int i=0;i<size;i++){
                    TreeNode element1 = q.poll();
                    TreeNode element2 = q.poll();
                    if(element1 == null && element2== null) continue;
                    if(element1 == null || element2== null || element1.val != element2.val){
                        return false;
                    }
                    q.add(element1.left);
                    q.add(element2.right);
                    q.add(element1.right);
                    q.add(element2.left);
                // }
            }
            return true;
        }
}

// DFS Method
// Time Complexity : O(n)
// Space Complexity : O(h).... O(n) worst case
class DFS {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        flag = true;
        dfs(root.left, root.right);
        return flag;    
    }
    
    private void dfs(TreeNode left, TreeNode right){
        //base
        if(left==null && right==null) return;
        
        if(left==null || right==null || left.val != right.val){
            flag=false;
            return;
        }
        
        //logic
        if(flag)
            dfs(left.left, right.right);
        
        if(flag)
            dfs(left.right, right.left);
    }
}