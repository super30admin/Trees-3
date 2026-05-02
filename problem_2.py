class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root):
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if not left or not right:
            return left == right

        if left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(
            left.right, right.left
        )