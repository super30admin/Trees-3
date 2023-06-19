# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        q = [(root, root.val, [root.val])]
        while q:
            curr, curr_sum, pathList = q.pop(0)

            if curr_sum == targetSum and not curr.left and not curr.right:
                res.append(pathList)
            if curr.left:
                pathList.append(curr.left.val)
                q.append((curr.left, curr_sum + curr.left.val, pathList))
            if curr.right:
                temp = pathList.append(curr.right.val)
                q.append((curr.right, curr_sum + curr.right.val, pathList))
        return res