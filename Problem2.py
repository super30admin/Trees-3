# Problem 2 : Symmetric Tree
# Time Complexity : O(n)
# Space Complexity : O(n)
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
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isMirror(nodeA: Optional[TreeNode], nodeB: Optional[TreeNode]) -> bool:
            # base case
            # when both nodes are null
            if nodeA is None and nodeB is None:
                return True
            # if one of the node is none or the values does not match means the sub trees are not mirrorof each other
            if nodeA is None or nodeB is None or nodeA.val != nodeB.val:
                return False
            # check left sub tree with right sub tree and right sub tree with left sub tree
            return isMirror(nodeA.left, nodeB.right) and isMirror(nodeA.right, nodeB.left)
        return isMirror(root, root)
        