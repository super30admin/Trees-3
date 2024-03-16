# https://leetcode.com/problems/symmetric-tree/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We traverse one level at a time using Queue. Whenever we add elements to the queue. We add left node
# right child and right node left child and compare them. If they are not equal we return False, else we return True
# at the end.
# left.left and right.right
# left.right and right.left are compared at every level.

from typing import Optional
from queue import Queue


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        _queue = Queue()
        if root is None:
            return False
        _queue.put(root.left)
        _queue.put(root.right)

        while _queue.qsize() > 0:
            left_node = _queue.get()
            right_node = _queue.get()

            if left_node is None and right_node is None:
                continue
            if left_node is None or right_node is None or left_node.val != right_node.val:
                return False

            _queue.put(left_node.left)
            _queue.put(right_node.right)
            _queue.put(left_node.right)
            _queue.put(right_node.left)

        return True
