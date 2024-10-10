# Time Complexity = O(n) | Space Complexity = O(h)

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root.left, root.right)

    def helper(self, root_left, root_right):

        if root_left is None and root_right is None:
            return True

        if root_left is None or root_right is None:
            return False

        if root_left.val == root_right.val:
            return self.helper(root_left.left, root_right.right) and \
                self.helper(root_left.right, root_right.left)

