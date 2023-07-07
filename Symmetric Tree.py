# Time complexity : O(n), number of nodes
# Space complexity : O(H), Height of the tree
# The code ran on Leetcode

# Recursively call the helper function on left.left, right.right and left.right, right.left. Whenever there is a mismatch of values, change the flag to false.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        def helper(left, right):
            # base
            if left == None and right == None:return
            if left == None or right == None or left.val != right.val:
                self.flag = False
                return

            # Logic
            helper(left.left, right.right)
            helper(left.right, right.left)

        helper(root.left, root.right)
        return self.flag