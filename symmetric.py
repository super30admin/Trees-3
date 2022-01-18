# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        left = []
        right = []

        return self.helper(root.left, root.right)

    def helper(self, root1, root2):

        if root1 == None and root2 == None:
            return True

        if root1 == None or root2 == None:
            return False

        if root1.val == root2.val:
            return self.helper(root1.left, root2.right) and self.helper(root2.left, root1.right)
        else:
            return False
