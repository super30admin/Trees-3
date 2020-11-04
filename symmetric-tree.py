# Time Complexity: O(n)
# Space Complexity: O(h)
# Approach:
# Use level order traversal here with a small change. Traverse the left and right subtrees simultaneously.
# it can be visualized as traversiong two trees and checking equality simultaneously.
# Enqueue the left and right child in a queue at every node. If at any stage the values differ or the number of children are unequal, return False.
# More comments inline...

from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True

        # Add 2 copies of the root to the queue
        q = deque([(root, root)])

        # Traverse in level order
        while q:
            nodeL, nodeR = q.popleft()

            # Different values, return False
            if nodeL.val != nodeR.val:
                return False

            # Check if the nodes are mirrored - left AND right children MUST be present
            # If either left or right child is missing, return FALSE
            if nodeL.left is not None and nodeR.right is not None:
                q.append((nodeL.left, nodeR.right))
            elif nodeL.left is not None or nodeR.right is not None:
                return False

            if nodeL.right is not None and nodeR.left is not None:
                q.append((nodeL.right, nodeR.left))
            elif nodeL.right is not None or nodeR.left is not None:
                return False

        return True
