# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(h) where h is the height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self._list = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.sum_helper(root, targetSum, [])
        return self._list

    def sum_helper(self, root: Optional[TreeNode], target_sum: int, path: List[int]):
        if root is None:
            return
        target_sum -= root.val
        path.append(root.val)
        if root.left is None and root.right is None:
            if target_sum == 0:
                self._list.append(path.copy())
        self.sum_helper(root.left, target_sum, path)
        path.pop()
        self.sum_helper(root.right, target_sum, path)