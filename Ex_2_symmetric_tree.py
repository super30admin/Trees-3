# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h) for recursion stack, where h is the height of the tree (worst case O(n))
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import Optional
from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    # Recursive Approach
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root.left, root.right)

    def isMirror(self, t1, t2):
        if t1 is None and t2 is None:
            return True
        
        if t1 is None or t2 is None:
            return False
        
        if t1.val != t2.val:
            return False
        
        return self.isMirror(t1.left, t2.right) and self.isMirror(t1.right, t2.left)

    
    # -------------------------------------------------------
    # Iterative Approach using Queue (BFS-style)
    # Time Complexity : O(n)
    # Space Complexity : O(n)

        # if not root:
        #     return True
        # queue = deque([(root.left, root.right)])
        # while queue:
        #     t1, t2 = queue.popleft()
        #     if t1 is None and t2 is None:
        #         continue
        #     if t1 is None or t2 is None or t1.val != t2.val:
        #         return False
        #     queue.append((t1.left, t2.right))
        #     queue.append((t1.right, t2.left))
        # return True

    # -------------------------------------------------------
    # Iterative Approach using Stack (DFS-style)
    # Time Complexity : O(n)
    # Space Complexity : O(n)

        # if not root:
        #     return True
        # stack = [(root.left, root.right)]
        # while stack:
        #     t1, t2 = stack.pop()
        #     if not t1 and not t2:
        #         continue
        #     if not t1 or not t2 or t1.val != t2.val:
        #         return False
        #     stack.append((t1.left, t2.right))
        #     stack.append((t1.right, t2.left))
        # return True
