# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS
class Solution:
    isValid = True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        self.isValid = True
        self.dfs(root.left, root.right)
        return self.isValid

    def dfs(self, left, right):
        if left is None and right is None:
            return
        if left is None or right is None or left.val != right.val:
            self.isValid = False
            return

        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)

# DFS
# TC = O(n).
# Space complexity : O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
