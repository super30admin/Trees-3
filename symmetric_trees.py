# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root) -> bool:

        '''
        TC: O(n)
        AS: O(h)
        '''

        # Empty tree >> symmetric
        if not root:
            return True 

        return self.isMirror(root.left, root.right)

        
    def isMirror(self, left, right):

        # Both nodes are None >> symmetric
        if not left and not right:
            return True

        # One node is None, other has value >> not symmetric
        if not left or not right:
            return False

        # Values don't match – not symmetric
        if left.val != right.val:
            return False 

        return self.isMirror(left.left, right.right) and self.isMirror(left.right, right.left)
