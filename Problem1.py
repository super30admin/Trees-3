'''
Time Complexity: O(n)
Space Complexity: O(h)
Run on Leetcode: YES
'''
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def helper(self, root: Optional[TreeNode], num: int, targetSum: int, path: list[int], result: list[list[int]]) -> None:
        path.append(root.val)
        num = num + root.val
        if not (root.left or root.right):
            if num == targetSum:
                result.append(path[:])
        if root.left:
            self.helper(root.left, num, targetSum, path, result)
        if root.right:
            self.helper(root.right, num, targetSum, path, result)
        path.pop()
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> list[list[int]]:
        result = []
        if not root:
            return []
        self.helper(root, 0, targetSum, [], result)
        return result