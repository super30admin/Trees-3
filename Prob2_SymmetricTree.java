// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        
        if(root == null)    return flag;
        check(root.left, root.right);
        return flag;
    }
    public void check(TreeNode left, TreeNode right){
        
        if(left == null && right == null){// If both nodes afre null -- return false
            return;
        }
        
        if(left == null || right == null || left.val != right.val){ // If one of the node is null or not having same values -- return false
            flag = false; 
            return;
        }
        
        check(left.left, right.right); // First recursice call
        //Stack.pop() happened here
        
        check(left.right, right.left);// Second recursice call
    }
} 

//for inorder TRAVERSAL 
// public void check(TreeNode left, TreeNode right){
        
//          if(left == null && right == null){
//             return;
//         }
        
//         if(left != null && right != null){
//             check(left.left, right.right);
//         }
//           //Stack.pop() happened here
//         if(left == null || right == null || left.val != right.val){
//             flag = false; 
//             return;
//         }
//         check(left.right, right.left);
// }
 
