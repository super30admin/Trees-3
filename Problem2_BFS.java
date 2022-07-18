//Time Complexity: O(n), where n is the no. of nodes
//Space Complexity: O(2^h), max, width of tree that will take up queue space. 
//Code run successfully on LeetCode.

public class Problem2_BFS {

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
            
            else if(left == null|| right == null|| left.val != right.val)
                return false;
            
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
