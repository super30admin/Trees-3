# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Space Complexity: O(h)

Time Complexity: O(n)

"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def rec(left, right):

            if not left and not right: 
                return True
            if not left or not right or left.val != right.val:
                return False

            return rec(left.left, right.right) and rec(left.right, right.left)

        return rec(root.left, root.right)
                
