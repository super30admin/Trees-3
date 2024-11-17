"""
TC: O(n) to traverse n nodes
SP: O(n) n nodes in call stack in the worst case
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(t1, t2):
            if t1 is None and t2 is None:
                return True
            if t1 is None or t2 is None:
                return False
            return (
                (t1.val == t2.val)
                and helper(t1.right, t2.left)
                and helper(t1.left, t2.right)
            )
        return helper(root, root)
