// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
    
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left==null && right==null) continue;
            if(left==null || right==null || left.val!=right.val){
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
    return true;
    }
    
}
