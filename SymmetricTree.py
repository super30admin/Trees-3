'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.flag = True

        def helper(left, right):
            if not left and not right:
                return
            if not left or not right:
                self.flag = False
                return
            if left.val != right.val:
                self.flag = False
            if self.flag:
                helper(left.left, right.right)
            if self.flag:
                helper(left.right, right.left)

        helper(root, root)
        return self.flag