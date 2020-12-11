/*
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        if left is None and right is None:
            return True
        
        if left is None or right is None or left.val != right.val:
            return False
        
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
*/

// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(n) because of traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We have to check whether left's left tree is equal to right's right tree and 
// left's right tree is equal to right's left tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}