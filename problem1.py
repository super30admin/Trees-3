'''
## Problem1 (https://leetcode.com/problems/path-sum-ii/)

Time Complexity : O(n) where n is total nodes in the tree
Space Complexity : O(h) where h is the maximum height of the tree (for the recursion stack) and path array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
  def pathSum(self, root, targetSum):
    self.paths = []
    self.targetSum = targetSum
    self.collectPathSumsRecursive(root, 0, []) # start the recursion with inital values as 0 and empty list for currentSum and currentPath
    return self.paths

  def collectPathSumsRecursive(self, root, currentSum, currentPath):
    # base case
    if not root:
      return

    # update current sum and current path list
    currentSum += root.val
    currentPath.append(root.val)

    # if current node is a leaf node and current sum meets targetSum, add a copy of currentPath to the 'paths' list instance variable
    if root.left == None and root.right == None and currentSum == self.targetSum:
      self.paths.append(currentPath.copy())

    # recurse on left and right sub tree
    self.collectPathSumsRecursive(root.left, currentSum, currentPath)
    self.collectPathSumsRecursive(root.right, currentSum, currentPath)

    # pop the current node value from currentPath as we are returning one step back in the recursion tree
    currentPath.pop()
