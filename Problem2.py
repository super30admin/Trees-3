# Problem2 (https://leetcode.com/problems/symmetric-tree/)
# Time Complexity: O(n),we visit every node in the tree exactly once
# Space Complexity: O(h),recursion stack goes as deep as the tree's height h

# Logic:
# 1. A tree is symmetric if its left subtree mirrors its right subtree.
# 2. Two nodes mirror each other when their values match AND their outer/inner children mirror.
# 3. We recurse with cross-pairing (left.left with right.right) to compare the mirror directly.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:                                 # empty tree is symmetric by default
            return True                                  # nothing to compare, so return True
        return self.helper(root.left, root.right)        # ask: do root's two children mirror each other?

    def helper(self, left, right):
        if left is None and right is None:               # both sides empty at the same spot
            return True                                  # they match perfectly, this pair is fine
        if left is None or right is None:                # exactly one side is empty (other isn't)
            return False                                 # one node has nothing to mirror,not symmetric
        if left.val != right.val:                        # both nodes exist but values differ
            return False                                 # mismatch found, not symmetric

        # cross-pair the children: outer with outer, inner with inner
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
        #                       outer pair                             inner pair 
        #both pairs must mirror (and) for this pair to be symmetric