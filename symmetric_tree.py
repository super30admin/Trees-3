# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def issym(left,right):
            if left is None and right is None:
                return True
            if not(left and right):
                return False
            if left.val!=right.val:
                return False
            return issym(left.left,right.right) and issym(left.right,right.left)
        return issym(root,root)