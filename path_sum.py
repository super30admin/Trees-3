#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 12 00:26:01 2021

@author: ameeshas11
"""

#Time Complexity : O(n)
#Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    out = []
    
    def helper(self, root, cur_sum, targetSum, path):
        if root == None:
            return
        cur_sum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if cur_sum == targetSum:
                self.out.append(deepcopy(path))
        self.helper(root.left, cur_sum, targetSum, path)
        self.helper(root.right, cur_sum, targetSum, path)
        
        #backtrack
        del path[-1]
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        self.out = []
        self.helper(root, 0, targetSum, path)
        return self.out