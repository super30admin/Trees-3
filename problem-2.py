"""
Problem: https://leetcode.com/problems/symmetric-tree/

Approach:

1. send left and right children of the root to a helper function
2. in the helper function check the condition if left.val is equal to right.val, if this condition is not true then the tree is not symmetric, so return false
3. recurse with the left and right children again

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def check(self,left,right):
        if (left==None and right==None):
            return True
        if(left==None or right==None or left.val!=right.val):
            return False
        return self.check(left.left,right.right) and self.check(left.right,right.left)
        
    def isSymmetric(self, root: TreeNode) -> bool:
        if root==None:
            return True
        return self.check(root.left,root.right)
        