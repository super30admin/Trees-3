#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 18 11:07:54 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        #base case
        if left == None and right == None:
            return True
        if not left or not right or left.val != right.val:
            return False
        #logic
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
        