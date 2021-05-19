/*Approach: 
    Use a global variable to check that the tree is symmetric or not. 
    Recursively call a function on the left and the right side of the tree to check that the value of the left child of the left node is eqault to the val of the right side of the right node
    If at any moment, this isn't correct, then set the global variable to false
    
    Time complexity: O(N)
    Space complexity: O(1)
*/
class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else
        {
            isValid=true;
            isSymmetric(root.left,  root.right);
        }
        return isValid;
    }
    
    private void isSymmetric(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) //leaf
            return;
        if(left==null || right==null || left.val != right.val)
        {
            isValid=false;
            return;
        }
        isSymmetric(left.left, right.right);
        isSymmetric(left.right, right.left);
    }
}