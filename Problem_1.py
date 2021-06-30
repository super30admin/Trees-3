from typing import List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Using recursion and making a new copy of array everytime to track the paths.
# Time Complexity : O(n * n) -> n to traverse all the nodes in a tree and n for each node for copying list
# Space Complexity : O(n * n) -> n for each node and n to save the path for each node
class Solution:    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if root == None:
            return
        self.target = targetSum
        self.result = []
        self.helper(root, 0, [])
        return self.result
     
    # def helper(self, root: TreeNode, currSum: int, path: List[int]) -> None:
    #     if root == None: 
    #         return
    #     currSum += root.val
    #     path.append(root.val)
    #     self.helper(root.left, currSum, path.copy())
    #     if root.left == None and root.right == None:
    #         if self.target == currSum:
    #             self.result.append(path)
    #             return
    #     self.helper(root.right, currSum, path.copy())


    # Backtracking solution to get the paths, uses only 1 list. We remove the node from path when it's recursive call is finished
    # Time Complexity: O(n) -> For traversing over each node and we do not need to traverse over path list
    # Space Complexity: O(n) -> Because using only 1 list
    def helper(self, root: TreeNode, currSum: int, path: List[int]) -> None:
        if root == None: 
            return
        currSum += root.val
        path.append(root.val)
        self.helper(root.left, currSum, path)
        if root.left == None and root.right == None:
            if self.target == currSum:
                self.result.append(path.copy())
        self.helper(root.right, currSum, path)
        path.pop()

