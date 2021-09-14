//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helperMethod(root, root);
    }
    
    public boolean helperMethod(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true;
        }
        if(r1 == null || r2 == null) {
            return false;
        }
        return (r1.val == r2.val) && helperMethod(r1.right, r2.left) && helperMethod(r1.left, r2.right);
    }
}