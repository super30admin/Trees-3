# -*- coding: utf-8 -*-
"""
Created on Tue Apr 27 13:02:02 2021

@author: jgdch
"""

#Time Compleixty:O(N**2), N is the number of ndoes in the tree
#Space Complexity:O(N)
#Passed all LC testcases succesfully
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def helper(self, node, remainingSum, path, paths):
        
        if not node:
            return 
        
        path.append(node.val)
        
        if remainingSum == node.val and not node.left and not node.right:
            paths.append(list(path))
        else:    
            self.helper(node.left, remainingSum - node.val, path, paths)
            self.helper(node.right, remainingSum - node.val, path, paths)
            
        path.pop()    
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        paths = []
        self.helper(root, sum, [], paths)
        return paths        