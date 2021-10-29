# 113. Path Sum II
# https://leetcode.com/problems/path-sum-ii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative Approach
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:    
    def pathSum(self, root, targetSum):
        if not root:
            return []
        
        res = []
        
        stack = [(root,[root.val], targetSum-root.val)]
        
        while stack:
            root, eleList, t = stack.pop()
            
            if root.left == None and root.right == None and t == 0:
                res.append(eleList)
            
            if root.right:
                stack.append((root.right,eleList+[root.right.val],t-root.right.val))
            
            if root.left:
                stack.append((root.left,eleList+[root.left.val],t-root.left.val))
        return res
