// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * BFS and keep adding all the nodes at the same level. 
 * If te values at the nodes don't match return false. 
 * If they are null, continue. 
 * Compare left.left and right.right and left.right and right.left  */


class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true; 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue; 
            if(left ==  null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true; 
    }
}