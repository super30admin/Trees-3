"""101. Symmetric Tree
TC - O(n)
Sc - O(maxDepth)
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
        return self.helper(root.left,root.right)
    
    def helper(self,t1,t2):
        if t1 == None and t2 == None:
            return True
        
        if t1 == None or t2 == None or t1.val != t2.val:
            return False
        
        return self.helper(t1.right,t2.left) and self.helper(t1.left,t2.right)
        
        
        