"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(n). In worst case scenario all the nodes can be push to queue

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        queue = deque()
        queue.append(root.left)
        queue.append(root.right)

        while queue:
            right = queue.pop()
            left = queue.pop()

            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False

            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)

        return True
