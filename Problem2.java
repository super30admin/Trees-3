//symmetric tree
//space complexity : o(h) - Max space consumed in the stack would be equal to height of tree and then the recursion would start unfolding
//but in worst case our tree could be linear in which case that would be equal to the number of nodes present. so worst case it would be o(n)
//time complexity : o(n) - we visit each node exactly once
public class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ){return true;}
        return dfs(root,root);
    }
    
    private boolean dfs(TreeNode left, TreeNode right){
       
         if(left==null && right==null){
            return true;
        }
        
        if(left==null || right == null){
            return false;
        }
        
        return (left.val==right.val) && (dfs(left.left,right.right)) && (dfs(left.right,right.left));
    }
}
