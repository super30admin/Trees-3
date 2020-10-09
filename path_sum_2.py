"""
Problem: 113. Path Sum II
Solution: Add list of list output by recursively iterating the tree for left and right subtree of each node
    - and deleting the last element after all nodes in the path are traversed
Time Complexity: O(n^2), iterate all the nodes and copy root-to-leaf paths to the output list
Space Complexity: O(n) considering the space taken by output, O(1) if we don't consider the space taken by output
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []

        self.final = []
        self.helper(root, [root.val], root.val, targetSum)
        return self.final

    def helper(self, root, temp, currentSum, targetSum):
        # Add the output only if its a leaf
        if root.left is None and root.right is None and currentSum == targetSum:
            self.final.append(temp)

        if root.left is not None:
            self.helper(root.left, temp + [root.left.val], currentSum + root.left.val, targetSum)

        if root.right is not None:
            self.helper(root.right, temp + [root.right.val], currentSum + root.right.val, targetSum)