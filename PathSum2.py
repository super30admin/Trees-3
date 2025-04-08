# Time Complexity: O(n)
# Space Complexity: O(n) when the tree is skewed
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No

import copy
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def helper(root, targetSum, currentSum, path: List[int]):
            
            if not root:
                return None
            currentSum = currentSum + root.val
            path.append(root.val)
            if not root.left and not root.right:
                if currentSum == targetSum:
                    return result.append(list(path))
            helper(root.left, targetSum, currentSum, copy.deepcopy(path))
            helper(root.right, targetSum, currentSum, copy.deepcopy(path))
        
        helper(root, targetSum, 0 , [])
        return result