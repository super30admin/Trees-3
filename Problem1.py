# Problem 1 : Path Sum II
# Time Complexity : O(n)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        def dfs(node: Optional[TreeNode], currSum: int) -> None:
            nonlocal paths, curr_path, targetSum

            # Basic case
            if node is None:
                return
            # Add the node value to current sum
            currSum += node.val
            # Add the node to current path list
            curr_path.append(node.val)

            # Check if it is leaf node and currSum is equal to targetSum
            if node.left is None and node.right is None and currSum == targetSum:
                # Save a copy of curr_path to path
                paths.append(curr_path[:])
            # traverse to left of the node
            dfs(node.left, currSum)
            dfs(node.right, currSum)
            # After traversing the node, pop the element from the current path list
            curr_path.pop()


        paths = []
        curr_path = []
        dfs(root, 0)
        return paths
        