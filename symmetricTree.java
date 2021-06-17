// Time Complexity : O(N) where N = number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
1. Keep traversing the left and right subtree symmetrically and check if the values are the same.
2. If they are not return false else return true.
*/

// Your code here along with comments explaining your approach
class Solution {
    public ArrayList<Integer> left = new ArrayList<Integer>();
    public ArrayList<Integer> right = new ArrayList<Integer>();

    public boolean isSymmetric(TreeNode root) {
        //Base Case
        if(root==null) return true;
        if(root.left == null && root.right == null) return true;

        //Get if the two subarrays are symmetric
        boolean hasSymmetry = checkForSymmetric(root, root);
        
        if(!hasSymmetry) return false;
        else return true;
    }
    
    public boolean checkForSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

            //Traverse symmetrically
        if (left != null && right != null && left.val == right.val)
            return (checkForSymmetric(left.left, right.right) && checkForSymmetric(left.right, right.left));

        //If none of the if conditions are true return false
        return false;
    }
}
