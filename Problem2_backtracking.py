# Time Complexity = O(n) | Space Complexity = O(h) + O(h)

from typing import Optional
from copy import deepcopy
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        self.result = []
        self.curr_arr = []
class Solution:

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> list[list[int]]:
        self.helper(root, targetSum, 0)
        return self.result

    def helper(self, root: Optional[TreeNode], targetSum: int, curr_sum: int):
        # base case
        if root is None: return

        # action
        curr_sum += root.val
        self.curr_arr.append(root.val)

        if root.left is None and root.right is None and curr_sum == targetSum:
            self.result.append(list(self.curr_arr))

        # recursing
        self.helper(root.left, targetSum, curr_sum)
        self.helper(root.right, targetSum, curr_sum)

        # backtracking
        self.curr_arr.pop()

