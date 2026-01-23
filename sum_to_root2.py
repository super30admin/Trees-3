from typing import Optional, List
from copy import deepcopy

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.target = targetSum
        self.curr_list = []
        self.result = []
        self.helper(root, 0)
        return self.result
    
    def helper(self, root, curr_sum):
        if not root:
            return
        curr_sum += root.val
        self.curr_list.append(root.val)
        if not (root.left or root.right):
            # leaf node
            if curr_sum == self.target:
                self.result.append(deepcopy(self.curr_list))
        self.helper(root.left, curr_sum)
        self.helper(root.right, curr_sum)
        self.curr_list.pop()
        