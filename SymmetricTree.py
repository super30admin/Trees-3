# // Time Complexity : dfs o(n) 
# // Space Complexity :o(h)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : different approaches for the recursion


# // Your code here along with comments explaining your approach
# idea is to check the value at roots left with roots right and then lefts right and rights left for symmetric property to be valid we can iterate over the tree in dfs
# using either bfs and dfs to achieve this 

# Definition for a binary tree node.
from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         res = True
#         if not root or (not root.left and not root.right) : return res
#         def dfs(left,right):
#             nonlocal res
#             #base
#             if not left and not right : return
#             if not left or not right:
#                  res = False
#                  return
#             #logic
#             if left.val != right.val : res = False
#             dfs(left.left,right.right)
#             dfs(left.right,right.left)
#         dfs(root.left,root.right)
#         return res

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         res = True
#         if not root or (not root.left and not root.right) : return True
#         def dfs(left,right):
#             #base
#             if not left and not right : return True
#             if not left or not right: return False
#             #logic
#             if left.val != right.val : return False
#             l = dfs(left.left,right.right)
#             r = dfs(left.right,right.left)
#             return l and r
#         return dfs(root.left,root.right)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         res = True
#         if not root  : return True
#         def dfs(left,right):
#             #base
#             if not left and not right : return True
#             if not left or not right or (left.val != right.val ): return False
#             return dfs(left.left,right.right) and dfs(left.right,right.left)
#         return dfs(root.left,root.right)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         if not root : return True
#         if not root.left and not root.right: return True
#         q = deque([root.left,root.right])
#         while q:
#             left = q.popleft()
#             right = q.popleft()
#             if not left and not right : continue
#             if not left or not right or (left.val!=right.val) : return False
#             q.append(left.left)
#             q.append(right.right)
#             q.append(left.right)
#             q.append(right.left)
#         return True

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         if not root : return True
#         if not root.left and not root.right: return True
#         if not root.left or not root.right : return False
#         q = deque([root.left,root.right])
#         while q:
#             left = q.popleft()
#             right = q.popleft()
#             if left.val != right.val : return False
#             if left.left and not right.right : return False
#             if not left.left and right.right: return False
#             if left.left and right.right:
#                 q.append(left.left)
#                 q.append(right.right)
#             if left.right and not right.left : return False
#             if not left.right and right.left: return False
#             if left.right and right.left:
#                 q.append(left.right)
#                 q.append(right.left)
#         return True
# using stack :
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root : return True
        if not root.left and not root.right: return True
        if not root.left or not root.right : return False
        s = [root.left,root.right]
        while s:
            left = s.pop()
            right = s.pop()
            if left.val != right.val : return False
            if left.left and not right.right : return False
            if not left.left and right.right: return False
            if left.left and right.right:
                s.append(left.left)
                s.append(right.right)
            if left.right and not right.left : return False
            if not left.right and right.left: return False
            if left.right and right.left:
                s.append(left.right)
                s.append(right.left)
        return True

        

        
        
        
        
        