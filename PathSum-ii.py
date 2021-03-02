# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(n^2)
# LeetCode: Y(https://leetcode.com/problems/path-sum-ii/)
# Approach: Track currentpath and currentsum and as soon as the traverdal hits a leaf node and currentsum equals targetsum, create a copy of currentpath and add it to the result
#           Perform backtracking by removing the last added value in the current path
class Solution:        
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        self.result = []
        
        # edge case
        if not root:
            return self.result
        
        # start traversing
        self.helper(root, targetSum, 0, [])
        
        return self.result
        
    def helper(self, root: TreeNode, targetSum: int, currentSum: int, currentPath: List[int]):
        
        # base case
        if not root:
            return
        
        # update currentsum
        currentSum += root.val
        
        # update current path
        currentPath.append(root.val)
        
        # if current node is a leaf node and current sum equals target sum then the current path is a part of the result
        if (not (root.left or root.right)) and (currentSum == targetSum):
                self.result.append(list(currentPath))
                
        # traverse left subtree
        self.helper(root.left, targetSum, currentSum, currentPath)
        
        # traverse right subtree
        self.helper(root.right, targetSum, currentSum, currentPath)
        
        # backtrack
        currentPath.pop()
