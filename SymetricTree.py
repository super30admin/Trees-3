# Time Complexity : O(N)
# Space Complexity : O(N)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def helper(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            return helper(left.left, right.right) and helper(left.right, right.left)
        return helper(root.left, root.right) if root else True