# // Time Complexity : O(n)
# // Space Complexity : O(h) h = height of the tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : All nodes' values were being added to the path.
#  After processing a node's subtrees, it must be removed from the path



# Definition for a binary tree node.
from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        pathsList = []
        
        self.dfs(root, 0, targetSum, [], pathsList)
        
        return pathsList
        
        
    def dfs(self, root: Optional[TreeNode], currSum: int, targetSum: int, path: List[int], pathsList: List[List[int]]):
        if not root:
            return
        
        currSum += root.val
        path.append(root.val)
        
        if (not root.left) and (not root.right) and currSum == targetSum: # if its a leaf node and sum == target
                pathsList.append([n for n in path])
        
            
        self.dfs(root.left, currSum, targetSum, path, pathsList)
        self.dfs(root.right, currSum, targetSum, path, pathsList)
        

        # We need to pop the node once we are done processing ALL of it's
        # subtrees.
        path.pop()