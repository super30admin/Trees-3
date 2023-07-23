# Time complexity: O(n)
# Space complexity: O(h) h : height of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        return self.checkSymmetry(root.left, root.right)

    def checkSymmetry(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        if left is None and right is None:
            return True

        if left is None or right is None:
            return False

        return (
            left.val == right.val
            and self.checkSymmetry(left.left, right.right)
            and self.checkSymmetry(left.right, right.left)
        )