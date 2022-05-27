# DFS
# Time Complexity: O(N)
# Space Complexity: O(H), height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag = False
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.dfs(root.left, root.right)
        return self.flag
        
    def dfs(self, left, right):
        if left is None and right is None:
            return
        if left is None or right is None or left.val != right.val:
            self.flag = False
            return
        
        
        self.dfs(left.left, right.right)
        if self.flag:
            self.dfs(left.right, right.left)