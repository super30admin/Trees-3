// Time Complexity : O(n) where n is number of nodes, since we traverse tree entirely once
// Space Complexity : O(n) where n is number of recursive calls - height of tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    //TC: O(n) where n is number of nodes, since we traverse tree entirely once
    
    //SC: O(n) where n is number of recursive calls - height of tree 
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root,root);//helper function
    }
    
    private boolean checkSymmetric(TreeNode root,TreeNode root1){
        /*Two subtrees are identical if roots of both subtrees are equal
        and left subtree of one subtree is equal to right subtree of others*/
        
        //if both are null then we reach the leaf nodes, hence true
        if(root==null && root1==null) return true;
        
        //if one part is null and other is not, then false
        if((root==null && root1!=null) || (root1==null && root!=null)) return false;
        
        //check for root values and sub-sequent left and right of subtrees
        return (root.val==root1.val) && checkSymmetric(root.left,root1.right) && checkSymmetric(root.right,root1.left);
    }
}
