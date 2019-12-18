#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 18 09:07:55 2019

@author: tanvirkaur
"""

# Time complexity = O(n)
# Space complexity = O(h)
class Solution(object):

    def pathSum(self, root, summ):
        result = []
        if not root:
            return result
        q = [(root,[root.val])]
        while q:
            node, ls = q.pop(0)
            if not node.left and not node.right and sum(ls) == summ:
                result.append(ls)
            if node.left:
                q.append((node.left, ls +[node.left.val]))
            if node.right:
                q.append((node.right, ls +[node.right.val]))
        return result
            