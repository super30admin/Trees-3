//Approach-1: Using the DFS - treating single tree as two different trees
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(H) - Height of the recursion stack - here height of the tree

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        //Left and right part of tree as two different trees
        return dfs(root.left, root.right); 
    }
    
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}


//Approach-2: Using the BFS
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(N) - leaf level
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                
                if(left == null && right == null) continue;
                if(left == null || right == null || left.val != right.val) return false;
                
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
        }
        
        return true;
    }
}