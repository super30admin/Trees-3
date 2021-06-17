// Time complexity - O(N)
//Space complexity - O(H)

class Solution {
    public boolean isSymmetric(TreeNode root) {

        return isMirror(root,root);


    }

    public boolean isMirror( TreeNode t1, TreeNode t2) {

        // if both the trees are null return true else false
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        // root value should be same mirror image so left and right value differs
        return (t1.val == t2.val) && isMirror(t1.left,t2.right) &&           isMirror(t1.right,t2.left);

    }


}