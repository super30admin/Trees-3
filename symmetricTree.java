/* Time complexity: O(n)
space complexity: O(n)

*/

class Solution{
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;

        return (check(left.left, right.right) && check(left.right, right.left));

    }
}