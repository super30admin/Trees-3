# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity : o(N)
# Space Complexity : O(N)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False
        return self.helper(root.left, root.right)

    def helper(self, p1, p2):
        if (not p1 and p2) or (p1 and not p2):
            return False
        if not p1 and not p2:
            return True
        if p1.val == p2.val:
            return self.helper(p1.left, p2.right) and self.helper(p1.right, p2.left)
        return False
