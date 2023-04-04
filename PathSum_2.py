# Time Complexity : O(N)
# Space Complexity : O(N)
# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        result = []
        def helper(node, target, path):
            if not node:
                return
            if not node.left and not node.right and target == node.val:
                path.append(node.val)
                result.append(path)
                return
            helper(node.left, target - node.val, path + [node.val])
            helper(node.right, target - node.val, path + [node.val])
        helper(root, targetSum, [])
        return result