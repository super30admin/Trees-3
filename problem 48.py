# https://leetcode.com/problems/symmetric-tree/

# Time Complexity : O(n)
# Space Complexity :O(h) h = height of the tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root.left,root.right)
    
    def isMirror(self, l: Optional[TreeNode], r: Optional[TreeNode]) -> bool:
        if not l and not r:
            return True
        if not l or not r:
            return False

        return l.val == r.val and self.isMirror(l.left,r.right) and self.isMirror(l.right,r.left)


        