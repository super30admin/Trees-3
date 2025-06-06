'''
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
'''
# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # what if we travel down both the sides, and see what we get? 
        # if both nodes are null...
        if not root:
            return True

        return self.is_mirror(root.left, root.right)


    def is_mirror(self, left, right):
        # if both are empty:
        if not left and not right:
            return True

        # if one is null but not the other...
        if not left or not right:
            return False

        # if values are different
        if left.val != right.val:
            return False

        # if their values are equal, recurse:
        #   left of t1 with right of t2
        #   right of t1 with left of t2
        return self.is_mirror(left.left, right.right) and self.is_mirror(left.right, right.left)


