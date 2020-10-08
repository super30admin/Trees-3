"""
Name: Srinidhi 
Did it run on LC: Yes

Time Complexity: O(n)
Space Complexity: O(n)

Logic: Inital base condition is that root common to nodex must have equal value
from there, for mirror condition check if left of root1 is equal to right or root2 and vice-versa
This will ensure that the tree is a mirror.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        def isMirror(r1,r2):
            if r1 is None and r2 is None:
                return True
            if r1 is None or r2 is None:
                return False
            
            return r1.val == r2.val and isMirror(r1.right,r2.left) and isMirror(r1.left,r2.right)
        return isMirror(root,root)