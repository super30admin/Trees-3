# Time Complexity : O(n)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:


#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root== None:
            return True
        q = deque()
        q.append(root.left)
        q.append(root.right)
        while q:
            left = q.popleft()
            right = q.popleft()
            if left==None and right == None:
                continue
            if left==None or right == None or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True
        