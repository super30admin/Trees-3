// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively call the lefts left and rights right and lefts right and rights left to see if they are equal, and return false if they are not. Can also maintain a flag if you want to cut the recursion when one fails. 
//isSymmetric2: Using BFS, we add the corresponding nodes as pairs and pop them at the same time and check if they are equal. Space complexity is O(h) for the recursive solution and O(n) for the BFS solution since we are storing all nodes in the queue.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right,right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if(left == null && right==null) continue;
            if(left == null || right==null || left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }
}
