from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# DFS
class Solution1:
    def __init__(self):
        self.flag = True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.symmetric_helper(root.left, root.right)
        return self.flag

    def symmetric_helper(self, left, right):
        if left is None and right is None:
            return
        if (left is not None and right is None) or \
                (right is not None and left is None) or \
                left.val != right.val:
            self.flag = False
            return
        if self.flag:
            self.symmetric_helper(left.left, right.right)
        if self.flag:
            self.symmetric_helper(right.left, left.right)


class Solution:

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        q.appendleft(root.left)
        q.append(root.right)
        while len(q) > 0:
            size = len(q)
            for i in range(size//2):
                curr_left = q.popleft()
                curr_right = q.pop()
                if curr_left is None and curr_right is None:
                    continue
                if (curr_left is not None and curr_right is None) or \
                        (curr_right is not None and curr_left is None) or \
                        curr_left.val != curr_right.val:
                    return False
                q.append(curr_right.left)
                q.appendleft(curr_left.right)
                q.append(curr_right.right)
                q.appendleft(curr_left.left)
        return True


