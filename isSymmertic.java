/*
- A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
- Time complexity - O(n) we traverse entire tree
- Space complexity-  Height of the tree.  worst case O(n) if unbalanced tree
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricUtil(root, root);
    }
    public  boolean isSymmetricUtil(TreeNode t1, TreeNode t2){
        if(t1 == null && t2== null)
            return true;
        if(t1 == null || t2== null)
            return false;
        //check ifleft subtree is a mirror reflection of the right subtree of the current node. 
        if(t1.val == t2.val && 
          isSymmetricUtil(t1.left, t2.right) &&
          isSymmetricUtil(t1.right , t2.left))
        return true;
        
        return false;
    }
}
