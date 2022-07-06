# Time Complexity : O(v+e)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.compare(root.left, root.right)

    def compare(self, root1, root2):
        # base case
        if root1 is None and root2 is None:
            return True
        # check if one side terminates earlier
        if root1 is None or root2 is None:
            return False
        # check for equal values
        if root1.val != root2.val:
            return False

        # recursive step
        return self.compare(root1.left, root2.right) and self.compare(root1.right, root2.left)
