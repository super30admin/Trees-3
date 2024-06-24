"""
Trees-3
Problem2 (https://leetcode.com/problems/symmetric-tree/)

Time Complexity : O(n)
Space Complexity : O(h) which is stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to traverse the tree in left.left, right.right and left.right, right,left combinations and when ever the left or right
is not none but there value is not equal then it's a non symmetric else it's a symmetric.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool: # Approach 1
        def dfs(left, right):
            if left is None and right is None:
                return

            if left is None or right is None or left.val != right.val:
                self.is_symmetric = False
                return
            
            dfs(left.left, right.right)
            dfs(left.right, right.left)

        if root is None:
            return False

        self.is_symmetric = True
        dfs(root.left, root.right)    
        return self.is_symmetric 
    

# Approach 2 without using global value
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(left, right):
            if left is None and right is None:
                return True

            if left is None or right is None or left.val != right.val:
                return False
            
            return dfs(left.left, right.right) and dfs(left.right, right.left)
            

        if root is None:
            return True

        return dfs(root.left, root.right)    
    
# Approach 3 iterative using stack
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        stack = [(root.left, root.right)]

        while len(stack) != 0:
            left, right = stack.pop()

            if left is None and right is None:
                continue 

            if left is None or right is None or left.val != right.val:
                return False

            stack.append((left.left,right.right))
            stack.append((left.right,right.left))

        return True

# Approach 4 using BFS
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        import queue
        if root is None:
            return True

        queue = queue.Queue()
        queue.put(root.left)
        queue.put(root.right)

        while not queue.empty():
            left = queue.get()
            right = queue.get()

            if left is None and right is None:
                continue 

            if left is None or right is None or left.val != right.val:
                return False

            queue.put(left.left)
            queue.put(right.right)
            queue.put(left.right)
            queue.put(right.left)
        
        return True
