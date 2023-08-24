//TC = O(n)
//SC = O(n)

class SymmetricTree{
    public boolean isSymmetric(TreeNode root) {
        return helper(root ,root);    
    }

    private boolean helper(TreeNode t1, TreeNode t2){
        //base
        if(t1 == null || t2 == null) return false;
        if(t1==null && t2 == null) return true;

        //logic
        return ((t.val==t2.val) && (helper(t1.left,t2.right)) && (t1.right,t2.left));
    }
}