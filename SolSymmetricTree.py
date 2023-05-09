"""
 TC = O(H) and SC = O(H) 
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.isSymmetricHelper(root.left, root.right)

    def isSymmetricHelper(self, left, right):
        if left == None and right == None:
            return True
        if left == None or right == None:
            return False
        if left.val != right.val:
            return False
        return self.isSymmetricHelper(left.left, right.right) and self.isSymmetricHelper(left.right, right.left)