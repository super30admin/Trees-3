// TimeComplexity: O(n) where n is number of nodes
// SpaceComplexity: O(n) 
// Explanation: I use a queue to compare nodes in pairs that should be mirror images of each other. Initially, I add the left and right children of the root. 
// At each step, I poll two nodes at a time and check whether they are both null or have equal values. If only one is null or their values differ, the tree is not symmetric. 
// When they match, I enqueue their children in mirrored order:left.left with right.right, and left.right with right.left. If all such mirrored pairs match, the tree is symmetric.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i <size; i=i+2) {
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if(left==null && right ==null) continue;
                if(left==null || right ==null || left.val!=right.val) {
                    return false;
                }
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
            
        }

      return true;  
    }
}