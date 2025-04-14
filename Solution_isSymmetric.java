//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode rootLeft, TreeNode rootRight){
        if(rootLeft == null && rootRight == null){
            return true;
        }
        if((rootLeft == null && rootRight != null) || (rootLeft != null && rootRight == null))
            return false;

        if(rootLeft.val != rootRight.val)
            return false;

        return helper(rootLeft.left, rootRight.right) && helper(rootLeft.right, rootRight.left);
    }

}
