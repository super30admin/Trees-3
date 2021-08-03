# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    """DFS Implementation
    Time complexity-O(n)
    Space complexity-O(1)"""
    # def __init__(self):
    #     self.Symmetric=True
        
    def isSymmetric(self, root: TreeNode) -> bool:
        if root and not root.left and not root.right:
            return True
        if not root.left or not root.right:
            return False
        if root.left and root.right:
            return self.helper(root.left, root.right)
        # return self.Symmetric
    
    def helper(self, left, right):
        if left ==None and right==None:
            # return 
            return True
        if left==None or right==None or left.val!=right.val:
            # self.Symmetric=False
            # return 
            return False
        # if self.Symmetric:
        #     self.helper(left.left, right.right)
        # if self.Symmetric:
        #     self.helper(left.right, right.left)
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
        
        
        
    
        """BFS Implementation
        Time complexity-O(n)
        Space complexity-O(n)"""
        # q=deque()
        # if root and not root.left and not root.right:
        #     return True
        # if not root.left or not root.right:
        #     return False
        # if root.left and root.right:
        #     q.append(root.left)
        #     q.append(root.right)
        # while q:
        #     length=len(q)
        #     for i in range(length//2):
        #         left=q.popleft()
        #         right=q.popleft()
        #         if left==None and right==None:
        #             continue
        #         if left==None or right==None or left.val!=right.val:
        #             return False
        #         if left.val==right.val:
        #             q.append(left.left)
        #             q.append(right.right)
        #             q.append(left.right)
        #             q.append(right.left)
        # return True
  