// Time Complexity : O(n)
// Space Complexity :O(n) 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()){
            
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            if(left==null && right==null) continue;
        
            if(left==null || right==null || left.val!=right.val){
                return false;
            }
            
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}