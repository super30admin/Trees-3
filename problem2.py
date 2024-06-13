'''
## Problem2 (https://leetcode.com/problems/symmetric-tree/)

Time Complexity : O(n) where n is total nodes in the tree
Space Complexity : O(h) where h is the maximum height of the tree (for the recursion stack)
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
  def isSymmetric(self, root) -> bool:
    # for a tree to be symmetric its left and right side should be mirror images
    return self.isMirror(root.left, root.right)

  def isMirror(self, root1, root2):
    # base case
    # if both roots are None, return True; if either one is None, return False
    if root1 == None:
      if root2 == None:
        return True
      return False

    if root2 == None:
      return False

    # if both roots are non None but values don't match, return False
    if root1.val != root2.val:
      return False

    # recurse on left of left with right of right and right of left with left of right
    return self.isMirror(root1.left, root2.right) and self.isMirror(root1.right, root2.left)
