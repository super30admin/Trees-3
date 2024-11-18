#TC: O(n)
#SC: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(l, r):
            if l is None and r is None:
                return True
            if (l is not None and r is None) or (r is not None and l is None) or l.val != r.val:
                return False
            return dfs(l.left, r.right) and dfs(l.right, r.left)
        return dfs(root, root)
