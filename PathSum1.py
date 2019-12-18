#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 18 09:07:34 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time complexity = O(n)
# Space complexity = O(h) if we consider the recursion stack

class Solution:
    def hasPathSum(self, root: TreeNode, summ: int) -> bool:
        self.ans = []
        if not root:
            return []
        self.helper(root, summ, [root.val])
        return self.ans
    def helper(self,root, summ, ls):
        #base case
        if not root.left and not root.right and sum(ls) == summ:
            self.ans.append(ls)
        #logic
        if root.left:
            self.helper(root.left, summ, ls+[root.left.val])
        if root.right:
            self.helper(root.right, summ, ls+[root.right.val])