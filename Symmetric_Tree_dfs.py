# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC: O(n)
# SC: O(h)
class Solution:
    def __init__(self):
        self.isValid = True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        left = root.left
        right = root.right

        self.dfs(left, right)
        return self.isValid

    def dfs(self, left, right):
        if left == None and right == None:
            return 
        if left == None or right == None or left.val != right.val:
            self.isValid = False
            return

        if self.isValid:
            self.dfs(left.left, right.right)
            self.dfs(left.right, right.left)
