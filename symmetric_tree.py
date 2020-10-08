"""
Problem: 101. Symmetric Tree
Solution: Recursive approach
Time Complexity: O(n), all numbers of the binary tree are traversed
Space Complexity: O(h), h is height, recursive call is bound by the height of the tree
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)

    def isMirror(self, t1, t2):
        if t1 is None and t2 is None:
            return True

        if t1 is None or t2 is None:
            return False

        if t1.val != t2.val:
            return False

        # if the node is equal on both left and right, recursively call function on both left and right subtree
        return self.isMirror(t1.left, t2.right) and self.isMirror(t1.right, t2.left)