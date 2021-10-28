# SC-O(n)
# TC-O(n)

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
        node1 = root.left
        node2 = root.right
        return self.helper(node1, node2)

    def helper(self, N1, N2):
        if N1 is None and N2 is None:
            return True
        elif N1 is None or N2 is None or N1.val != N2.val:
            return False
        return self.helper(N1.left, N2.right) and self.helper(N1.right, N2.left)