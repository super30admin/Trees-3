// Time Complexity: O(n)
// Space complexity: O(h)

// Approach:
// If we look at the diagram given below, it is a mirror image

//                1
//              /   \
//             2     2
//            /\     /\
//           3  4   4  3

// We can start from the bottom,
// Left-Left = Right-Right, Left-Right=Right-Left and Left=right;
// We have a boolean recurse function which takes left subtree and right subtree as parameters and
// First we need to check if both left and right are null, return true 
// This is the base case, it has to be the first check 
// Then we check if either of left or right are null, return false and if left value != right value return false
// We finally call recursion again for  Left-Left = Right-Right, Left-Right=Right-Left

class Solution {

    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left,root.right);
       
    }
    
    private boolean checkSymmetric(TreeNode left,TreeNode right){
       
       // this check needs to be first
       // base condition or we might have reached the leaf
       if(left==null && right==null){
           return true;
       }
        
        // if either one is null return false
        if(left==null || right==null)
       {
           return false;
       }
        
        // if the values are not same return false
        if(left.val != right.val){
           return false;
       }
        
       
        // left left should be = right right & left right should be = right left
        return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
    }
}
