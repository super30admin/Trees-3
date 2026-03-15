#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 101: Symmetric Tree
    Link: https://leetcode.com/problems/symmetric-tree/

    Problem:
    Given the root of a binary tree, check whether it is a mirror of itself
    (i.e., symmetric around its center).

    Approach:
    BFS using a deque. Push the root twice to seed the comparison.
    At each step, pop two nodes (left and right mirrors) and compare their values.
    Then enqueue their children in mirror order:
      - left.left paired with right.right (outer pair)
      - left.right paired with right.left (inner pair)

    1️⃣ Seed queue with root twice.
    2️⃣ Pop two nodes at a time; if both None → continue; one None or values differ → False.
    3️⃣ Enqueue outer pair (left.left, right.right) then inner pair (left.right, right.left).
    4️⃣ If queue empties without returning False → return True.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(n)
        Queue holds at most O(n) nodes at a level.

"""

from collections import deque
from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Keep left child of left parent and right child of right parent together in queue
        # Keep right child of left parent and left child of right parent together in queue
        queue = deque()
        queue.append(root)
        queue.append(root)

        while queue:
            left = queue.popleft()
            right = queue.popleft()
            if left is None and right is None:
                continue
            elif left is None or right is None:
                return False
            elif left.val != right.val:
                return False

            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)

        return True

    '''
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Using queue, add left and right child even if they are null. At for each node check if it
        # is not null only then add child.
        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            level = []
            for i in range(size):
                node = queue.popleft()
                level.append(node)

                if node:
                    queue.append(node.left)
                    queue.append(node.right)
            l = 0
            r = len(level) - 1
            while l < r:
                left = level[l]
                right = level[r]
                if left is None and right is None:
                    l += 1
                    r -= 1
                    continue
                elif left is None or right is None:
                    return False
                elif left.val != right.val:
                    return False
                l += 1
                r -= 1
        return True
    '''

    '''
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(left, right):
            if left is None and right is None:
                return True
            elif left is None or right is None:
                return False
            elif left.val != right.val:
                return False
            # returning by this way reduces operations because as soon as it sees
            # false in any of the sides it will return False
            return dfs(left.left, right.right) and dfs(left.right, right.left)

        return dfs(root, root)
    '''
