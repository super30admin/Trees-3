# Definition for a binary tree node.
# accepted in leetcode(101)
# time - O(N)
# To the helper function pass left node and right node and compare, if they are not equal return false else look further.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:  # not a symettric tree as either the left or right node in missing
            return False
        if left.val == right.val:
            outerSide = self.helper(left.left, right.right)
            innerSide = self.helper(left.right, right.left)
            return (outerSide and innerSide)  # if both are equal returns true else false