#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 18 11:07:27 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# time complexity = O(n)
# space complexity = O(h) where h is the height of the tree
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        q = [(root.left, root.right)]
        print(q)
        while q:
            left, right = q.pop(0)
            if left == None and right == None:
                continue
            elif left == None or right == None or left.val != right.val:
                return False
            q.append((left.left,right.right))
            q.append((left.right,right.left))
        return True
        