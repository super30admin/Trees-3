// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    //TC : O(N)
    //SC: O(N)
    public boolean isSymmetric(TreeNode root) {
        return dfs(root);
    }

    public boolean dfs (TreeNode root){
        if(root == null ){
            return true;
        }
        return isSymetric(root.left,root.right);
    }

    public boolean isSymetric(TreeNode node1 , TreeNode node2) {
        if(node1 == null && node2 == null ) return true;
        if(node1 == null || node2 == null ) return false;
        if(node1.val != node2.val) return false;

        return isSymetric(node1.left,node2.right) && isSymetric(node1.right,node2.left);
    }
}