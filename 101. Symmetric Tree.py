#TC O(n) and SC O(h) -> recursive stack space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.isSymmetric = True
        self.dfs(root.left, root.right)
        return self.isSymmetric
        
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> None:
        if left == None and right==None:
            return
        if left == None or right==None:
            self.isSymmetric = False
            return
        if left.val != right.val:
            self.isSymmetric = False
            return
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)



#Using BFS - level ordered search
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        q = Queue()
        q.put(root.left)
        q.put(root.right)
        while not q.empty():
            left = q.get()
            right = q.get()
            if left == None and right == None:
                continue
            if left == None or right == None:
                return False
            if left.val != right.val:
                return False
            q.put(left.left)
            q.put(right.right)
            q.put(left.right)
            q.put(right.left)
        return True