'''
Problem2 (https://leetcode.com/problems/symmetric-tree/)
'''

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool: # type: ignore
        if root == None:
            return True
        
        left = root.left
        right = root.right
        
        q = deque()
        q.append((left, right))

        while q:
            left, right = q.popleft()

            if left is None and right is None:
                continue

            if ((left == None) and (right != None)) or ((right == None) and (left != None)):
                return False

            if left.val != right.val:
                return False

            else:
                q.append((left.left, right.right))
                q.append((left.right, right.left)) 

        return True               


