# Time Complexity : O(n)
# Space Complexity : O(n) -> recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Three line explanation of solution in plain english:
# 1. If the tree is empty, it is symmetric.
# 2. Recursively compare left and right subtrees, checking node values.
# 3. For each pair, check outer (left.left vs right.right) and inner (left.right vs right.left) children for symmetry.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # If root is None, tree is symmetric
        if not root:
            return True
        # Start recursive comparison between left and right subtrees
        return self.helper(root.left, root.right)

    def helper(self, left_root, right_root):
        # If both nodes are None, symmetric at this branch
        if not left_root and not right_root:
            return True
        # If one node is None or values differ, not symmetric
        if not left_root or not right_root or left_root.val != right_root.val:
            return False
        # Recursively check outer children (left.left vs right.right)
        # and inner children (left.right vs right.left)
        return self.helper(left_root.left, right_root.right) and \
               self.helper(left_root.right, right_root.left)
