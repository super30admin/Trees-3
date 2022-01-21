'''
TC: O(n)
RC: O(H)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        if not root.left and not root.right:
            return True
        
        
        def rec(left, right):
            
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            if not left.left and right.right:
                return False
            if not right.right and left.left:
                return False
            
            return rec(left.left, right.right) and rec(left.right, right.left)
        
        return rec(root, root)