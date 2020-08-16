# Time Complexity :O(n) where n is number of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # edge case
        if root is None:
            return True
        return self.check(root.left, root.right)

    def check(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val != right.val:
            return False
        return self.check(left.left, right.right) and self.check(left.right, right.left)


# if you define a new function, add self as the first argument in function definition and add self.function name when you call it
