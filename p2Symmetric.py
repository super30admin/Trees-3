"""
Given the root of a binary tree, 
check whether it is a mirror of itself (i.e., symmetric around its center).

 

// Time Complexity : O(N)
// Space Complexity : O(LogN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class Solution:
  def isSymmetric(self, root):
    if root is None:
      return True
    else:
      return self.isMirror(root.left, root.right)

  def isMirror(self, left, right):
    if left is None and right is None:
      return True
    if left is None or right is None:
      return False

    if left.val == right.val:
      outPair = self.isMirror(left.left, right.right)
      inPiar = self.isMirror(left.right, right.left)
      return outPair and inPiar
    else:
      return False