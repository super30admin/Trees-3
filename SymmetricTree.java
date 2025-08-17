import javax.swing.tree.TreeNode;

//Idea is to compare the left node of the left tree with right node of the right tree and
// right node of the left tree with left node of the right tree
//Time Complexity: O(n)
//Space Complexity: O(logn )

public class SymmetricTree {
        public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode lefttreenode, TreeNode righttreenode)
    {
        if(lefttreenode==null&&righttreenode==null)
        {
            return true;
        }
        if(lefttreenode==null || righttreenode==null)
        {
            return false;
        }
        return lefttreenode.val==righttreenode.val && compare(lefttreenode.left,righttreenode.right) && compare(lefttreenode.right,righttreenode.left);
    }
}
