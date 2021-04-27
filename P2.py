# -*- coding: utf-8 -*-
"""
Created on Tue Apr 27 13:02:47 2021

@author: jgdch
"""

#Time Compleixty:O(N), N is the number of ndoes in the tree
#Space Complexity:O(H), H is the height of the tree
#Passed all LC testcases succesfully

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isSym(root,root)
    def isSym(self,root,root1):
        if(root==None and root1==None):
            return True
        if(root==None or root1==None):
            return False
        return (root.val==root1.val) and self.isSym(root.right,root1.left) and self.isSym(root.left,root1.right)
    
        