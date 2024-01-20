//Accepted on LT
//Pass left and right in dfs manner go down both was and keep checking,maintain a global flag change it if something fails.
//Time should be O(n)

class Solution {
    boolean t;
    HashSet<Integer> hs;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        this.t = true;
        this.hs = new HashSet<>();
        helper(root.left,root.right);
        return t;
        
    }
    public void helper(TreeNode left,TreeNode right){
        if(left==null && right==null) return;

        if(left==null || right==null || left.val!=right.val){
            t=false;
            return;
        }
        helper(left.left,right.right);
        helper(left.right,right.left);

        return;
    }
}