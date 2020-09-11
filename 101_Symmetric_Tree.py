# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Leetcode problem link : https://leetcode.com/problems/symmetric-tree/
# Time Complexity : O(n) where c is the no of leaves or diameter and maxdepth is the max length from root to leaf anywhere in the tree
#  Space Complexity : O(max depth)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Intuition => The approach is comparing left of left and right of right and comparing right of left and left of right pointers This can be done iteratively using a stack or recursively
        
      '''
class Solution:
    # iterative
    def isSymmetric(self, root):
        if not root:
            return True
        stack = [(root.left, root.right)]
        while stack:
            p1, p2 = stack.pop()
            if not p1 and not p2:
                continue
            if not p1 or not p2 or (p1.val != p2.val):
                return False
            stack.append((p1.left, p2.right))
            stack.append((p1.right, p2.left))
        return True
    
    # recursive
    def isSymmetric(self, root):
        if not root:
            return True
        return self.recursive(root.left,root.right)
    
    def recursive(self,p1,p2):
        if not p1 and not p2:
            return True
        if not p1 or not p2 or p1.val!= p2.val:
            return False
        return self.recursive(p1.left,p2.right) and self.recursive(p1.right,p2.left)
    