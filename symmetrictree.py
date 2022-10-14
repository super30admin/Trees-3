##Time Complexity : O(n)
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes
DFS Iterative Solution:
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None: 
                return True
        def dfs_left(root, result):
            if root is None:
                result.append(None)
                return
            result.append(root.val)
            dfs_left(root.left, result)
            dfs_left(root.right, result)
            return result
        def dfs_right(root, result):
            if root is None: 
                result.append(None)
                return
            result.append(root.val)
            dfs_right(root.right, result)
            dfs_right(root.left, result)
            return result
        return dfs_left(root.left, [])==dfs_right(root.right, []) 
        