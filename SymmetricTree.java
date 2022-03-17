// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        //leaft nodes
        else if(root.left == null && root.right == null){
            return true;
        }else {
            //on right and left subtrees
            return isSymmetricHelper(root.left, root.right);
        }
    }
    
    public boolean isSymmetricHelper(TreeNode a, TreeNode b){
        //both null then true
        if(a== null && b==null){
            return true;
        }
        else if(a == null || b == null){
            return false;
        }
        else if(a.val != b.val){
            return false;
        }
        //call helper method on left of left subtree and right of right subtree and 
        //right of left subtree and left of right subtree
        return (isSymmetricHelper(a.left, b.right) && isSymmetricHelper(a.right, b.left));
    }
}