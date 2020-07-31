# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    # BFS
    def isSymmetric(self, root: TreeNode) -> bool:
        """
        // Time Complexity : O(n/2) i.e O(n)
        // Space Complexity : O(n/2) i.e O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        // Three line explanation of solution in plain english:
            - Store initial root left and root right pairs in a tuple in a stack.
            - Recursively compare the left.left with right.right and
              left.right with right.left
            - Case to consider:
                Both are none: Continue
                One of the node is None: False
                Value is not equal: False
        """
        # edge case
        if root is None:
            return True

        queue = deque()
        queue.append((root.left, root.right))
        while queue:
            left, right = queue.popleft()
            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val != right.val:
                return False
            queue.append((left.left, right.right))
            queue.append((left.right, right.left))
        return True

    def isSymmetricRecursive(self, root: TreeNode) -> bool:
        """
        // Time Complexity : O(n/2) i.e O(n)
        // Space Complexity : O(2h) or O(h) recursive stack else O(1).
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        """
        if root is None:
            return True
        return self._helper((root.left, root.right))

    def _helper(self, node: tuple) -> bool:
        left, right = node
        # base
        if left is None and right is None: return True
        if left is None or right is None: return False
        if left.val != right.val: return False
        # logic
        return self._helper((left.left, right.right)) and self._helper((left.right, right.left))
