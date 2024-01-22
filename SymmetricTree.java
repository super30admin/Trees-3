// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: DFS(recursion)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
    
        }

        if(left==null || right== null || left.val!=right.val) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}