# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def helper(self, left, right):
        if left is None and right is None:
            return
        if left is None or right is None:
            self.result = False
            return
        if left.val != right.val:
            self.result = False
            return
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)

    def isSymmetric(self, root) :

        if root is None:
            return
        self.result = True
        self.helper(root.left, root.right)
        return self.result