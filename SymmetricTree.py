# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The idea is to check for left and right subtree and then for those each left and right subtree, check for left subtree's left
# and right subtree's right, and left subtree's right and right subtree's left for a symmetry

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.isMirror(root.left, root.right)

    def isMirror(self, t1, t2):
        if not t1 and not t2:
            return True
        if not t1 or not t2:
            return False

        return (t1.val == t2.val and self.isMirror(t1.left, t2.right) and
                self.isMirror(t1.right, t2.left))