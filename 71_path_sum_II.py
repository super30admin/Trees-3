# Time complexity - O(n*h) # copying of elements from prev list to next adds (*h) complexity
# Space complexity - O(h) + O(n*h) # n lists created with max of h elements in stack

# Approach - With helper recursive function that keeps track of the current sum, path associated to that
# sum. Important note: Need to create deep copy of path to append accurate path in result, which otherwise
# get messed up due to pointer references.

from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0, [], targetSum)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int) -> None:
        # base case
        if root == None:
            return
        # logic
        currSum += root.val
        path.append(root.val) # to create a copy, to have accurate pointer references
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(path)
        
        self.dfs(root.left, currSum, [i for i in path], targetSum)
        self.dfs(root.right, currSum, [i for i in path], targetSum)