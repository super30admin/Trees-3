# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        
        def helper(root1, root2):
            
            if root1 is None and root2 is None:
                return True
            
            if root1 is None or root2 is None:
                return False
            
            return root1.val == root2.val and helper(root1.left, root2.right) and helper(root1.right, root2.left)
        
        
        return helper(root, root)