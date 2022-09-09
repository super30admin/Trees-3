/**
## Problem2 (https://leetcode.com/problems/symmetric-tree/)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (101. Symmetric Tree)
Any problem you faced while coding this :       No
 */

// Input: root = [1,2,2,3,4,4,3]
// Logic: recusrively check if left == right
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root!= null){
            return (isSymmetric(root.left) == isSymmetric(root.right));
        }
        return false;
    }
}