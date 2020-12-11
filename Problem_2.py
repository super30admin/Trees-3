# Symmetric Trees

# Time Complexity : O(N)
# Space Complexity : O(h) where h is height of the tree
# Did this code successfully run on Leetcode : Yes with Runtime: 36 ms and Memory Usage: 14.4 MB 
# Any problem you faced while coding this : After Class No
# Your code here along with comments explaining your approach :
# Approach
"""
Case wise condition is establihed and Implementation is done using Recursive 
approach. In order to be symmetric the major case is to have left of left equal to
right of right and left of right equal to right of left.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:  
        def sym(r1,r2):
            if r1 is None and r2 is None:
                 return True
            if r1 != None and r2 != None:
                if r1.val == r2.val:
                    return sym(r1.left,r2.right) and sym(r1.right,r2.left)
            return False
        return sym(root,root)