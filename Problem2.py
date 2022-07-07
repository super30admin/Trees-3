'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from collections import deque
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isPal(self, arr) -> bool:
        start = 0
        end = len(arr) - 1
        while start < end:
            if arr[start] != arr[end]:
                return False
            start += 1
            end -= 1
        return True
    
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = deque()
        queue.append(root.left)
        queue.append(root.right)
        while(len(queue) != 0):
            size = len(queue)
            for _ in range(0,size,2):
                left = queue.popleft()
                right = queue.popleft()
                if left == None and right == None:
                    continue
                if left == None or right == None or left.val != right.val:
                    return False
                queue.append(left.left)
                queue.append(right.right)
                queue.append(left.right)
                queue.append(right.left)

        return True