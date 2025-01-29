# Time complexity - O(n*h) # copying of elements from prev list to next adds (*h) complexity
# Space complexity - O(h) + O(h) # now lists created for only those elements that add up to the target sum

# Approach 2 (more efficient) - With helper recursive function that keeps track of the current sum, 
# path associated to that sum. In this case, need to create deep copy only when appending the path to 
# result, which otherwise get messed up due to pointer references.

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
                self.result.append([i for i in path])
        
        self.dfs(root.left, currSum, path, targetSum)
        self.dfs(root.right, currSum, path, targetSum)
        path.pop()