# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC: O(N)
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/symmetric-tree/)
# Approach: left'left = right'right, left'right = right'left(conditions to be checked)
#           Start traversal from left and right subtree simultaneously
#           Go level by level performing checks and return False on mismatch

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
   
        return self.helper(root.left, root.right)
        
        
    def helper(self, left: TreeNode, right: TreeNode) -> bool:
        
        # match but end
        if left == None and right == None:
            return True
        
        # mismatch
        elif (left == None) ^ (right == None):
            return False
        
        # match and continue
        elif left.val == right.val:
            return self.helper(left.left, right.right) and self.helper(left.right, right.left)
        
        # value mismatch
        else:
            return False
        
