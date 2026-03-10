# Symmetric Tree

# Definition for a binary tree node.

# Time complexity -> On
# Space Complexity -> On (Contains max breadth in the queue)
# Logic -> Place the supposed to be symmetric items in the queue together, opo both together, compare and continue

from collections import deque

# Create a queue
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        
        q.append(root.left)
        q.append(root.right)

        while len(q) > 0:
            leftElemnt = q.popleft()
            rightElement = q.popleft()
            if leftElemnt == None and rightElement == None:
                continue
            if leftElemnt == None or rightElement == None:
                return False
            if leftElemnt.val != rightElement.val:
                return False
            q.append(leftElemnt.left)
            q.append(rightElement.right)
            q.append(leftElemnt.right)
            q,append(rightElement.left)
            

        return True