    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/symmetric-tree/
    Time Complexity for operators : o(n) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach :

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
            # 1st one - Recursive Approach
                    A. create function and pass root as two separate trees to function
                    B. check if both null then its true.
                    C. check if values r not equal or any of the tree is null then return false.
                    D. recusive call to t1.left t2.right && t1.right t2.left 
              2md One - Iterative approach
                    A. possible with queue. Add 2 times to the queue and poll two times and check the values are equal.
                    B  and those two polled nodes consder as t1 and t2 and traverse left right and right left. 
       */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

   class symmetriicTree {

    public boolean isSymmetric(TreeNode root) {
        boolean flag = false;
        TreeNode p1 = root;
        TreeNode p2 = root;
        flag = checkSymmetry(p1,p2);
        return flag;
    }
    
    private boolean checkSymmetry(TreeNode p1, TreeNode p2){
        
        if(p1 == null && p2==null)
            return true;
        
        if(p1 == null || p2 == null || p1.val != p2.val)
            return false;
        
        
        return (checkSymmetry(p1.left,p2.right) && checkSymmetry(p1.right,p2.left));
    }
}