class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(h) - height of the tree

    def isSymmetric(self, root) -> bool:
        self.isValid = True
        if root is None:
            return self.isValid
        self.dfs(root.left, root.right)
        return self.isValid

    def dfs(self, left, right):
        # Base Condition
        if left is None and right is None:
            return
        if (left is None or right is None) or (left.val != right.val):
            self.isValid = False
            return

        # Logic
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)