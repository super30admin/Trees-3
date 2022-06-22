""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# BFS
from collections import deque
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        q.append(root.left)
        q.append(root.right)

        while q:
            left = q.popleft()
            right = q.popleft()

            if not left and not right:
                continue
            if not left or not right or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True

# DFS- Recursion
# // Time Complexity : O(n)
# // Space Complexity : O(h)
# class Solution:
#     def __init__(self):
#         self.flag=True
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         self.helper(root.left, root.right)
#         return self.flag

#     def helper(self, left, right):
#         if not left and not right:
#             return
#         if not left or not right or left.val!=right.val:
#             self.flag=False
#             return

#         self.helper(left.left, right.right)
#         if self.flag:
#             self.helper(left.right, right.left)

# DFS- Iterative
# // Time Complexity : O(n)
# // Space Complexity : O(h)
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         st=[]
#         st.append(root.right)
#         st.append(root.left)

#         while st:
#             left=st.pop()
#             right=st.pop()

#             if not left and not right:
#                 continue
#             if not left or not right or left.val!=right.val:
#                 return False
#             st.append(left.left)
#             st.append(right.right)
#             st.append(left.right)
#             st.append(right.left)
#         return True

















