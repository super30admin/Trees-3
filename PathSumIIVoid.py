'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []

        def helper(root, currSum, path):
            if not root:
                return
            currSum += root.val
            path.append(root.val)
            if (not root.left and not root.right) and currSum == targetSum:
                self.res.append(list(path))
                path.pop()
                return 
            helper(root.left, currSum, path)
            helper(root.right, currSum, path)
            path.pop()

        helper(root, 0, [])
        return self.res