# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, need to practice more on backtracking process

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        result = []

        def isLeaf(node):  # check if leaf node
            if node.left == None and node.right == None:
                return True
            return False

        def backtrack(node, remain, comb):
            if isLeaf(node):  # for leaf node
                if remain == 0:
                    result.append(list(comb))
                return

            if node.left:  # for nodes on left
                comb.append(node.left.val)
                backtrack(node.left, remain - node.left.val, comb)
                comb.pop()

            if node.right:  # for nodes on right
                comb.append(node.right.val)
                backtrack(node.right, remain - node.right.val, comb)
                comb.pop()

        if not root:
            return []

        backtrack(root, targetSum-root.val, [root.val])
        return result
