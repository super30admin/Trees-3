## Problem2 (https://leetcode.com/problems/symmetric-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True
        return self.check(root.left, root.right)
    
    def check(self, l: TreeNode, r: TreeNode) -> bool:
        if not l and not r: return True
        if not l or not r: return False
        if l.val != r.val: return False
        return self.check(l.left, r.right) and self.check(l.right, r.left)
    
    #Time Complexity: O(n)
    #Space Complexity: O(1)
