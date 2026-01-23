from typing import Optional
from collections import deque
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root or not(root.left or root.right):
            return True
        q = deque()
        q.append(root)
        while q:
            if len(q)==1:
                node = q.popleft()
                q.append(node.left)
                q.append(node.right)
            else:
                node1, node2 = q.popleft(), q.popleft()
            
                if (node1 and node2 and node1.val == node2.val):
                    q.append(node1.left)
                    q.append(node2.right)
                    q.append(node1.right)
                    q.append(node2.left)
                    continue
                elif (node1==None and node2==None):
                    continue
                else:
                    return False
        return True


        