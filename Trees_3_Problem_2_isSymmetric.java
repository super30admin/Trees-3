//Time Complexity : O(n) We will be traversing the whole list
//Space Complexity : O(1) (Stack space which will be the height of the tree)
//Run Successfully on leetcode
//No problem




public class Trees_3_Problem_2_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
        {
            return p==q;
        }
        if(p.val != q.val)
        {
            return false;
        }
        else return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);


    }
}
