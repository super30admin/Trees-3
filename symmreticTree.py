# Time = O(N), n = number of nodes, Space = O(height of tree)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.isSymmetric = True
        self.dfs(root.left, root.right)
        return self.isSymmetric
    
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> None:
        # base case
        if left == None and right == None:
            return
        # logic
        if left == None or right == None or left.val != right.val :
            self.isSymmetric = False
            return
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)