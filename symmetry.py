#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        q=Queue()
        q.put(root.left)
        q.put(root.right)

        while not(q.empty()):
            left=q.get()
            right=q.get()
            
            if left==None and right==None:
                continue
            if left==None or right==None:
                return False
            if left.val !=right.val:
                return False
            q.put(left.left)
            q.put(right.right)
            q.put(left.right)
            q.put(right.left)

        return True