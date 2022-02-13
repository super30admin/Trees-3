#time-n,space-n
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q=deque()
        q.append(root)
        q.append(root)
        while q:
            
            curr1=q.popleft()
            curr2=q.popleft()
            if curr1 is None and curr2 is None:
                continue
            
            if curr1 is None or curr2 is None or curr1.val != curr2.val:
                    return False
           
            q.append(curr1.left)
            q.append(curr2.right)
            q.append(curr1.right)
            q.append(curr2.left)
        return True
            
