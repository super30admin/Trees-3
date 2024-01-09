"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(n). In worst case scenario all the nodes can be push to recursive stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.dfs(root.left, root.right)

    def dfs(self, left, right):
        # base case
        if left == None and right == None:
            return True
        if left == None and right != None:
            return False
        if left != None and right == None:
            return False
        if left.val != right.val:
            return False

        # logic
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)
