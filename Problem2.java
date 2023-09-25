import javax.swing.tree.TreeNode;

//T.C  : O(n)
//S.C : O(h)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No



public class Problem2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);


    }
    public boolean dfs(TreeNode left ,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right ==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
