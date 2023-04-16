# Time Complexity : O(n) because we are traversing the tree once
# Space Complexity : O(h) because we are using a stack to traverse the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this problem, we check if the tree is symmetric or not by conducting a preorder and postorder traversal of 
the tree for the left and right subtrees respectively.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.isValid = True
        self.dfs(root.left, root.right)

        return self.isValid

    def dfs(self, left, right):
        if left == None and right == None: return

        if left == None or right == None:
            self.isValid = False
            return
        
        if left.val != right.val:
            self.isValid = False
            return

        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)