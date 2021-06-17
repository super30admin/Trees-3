# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#adding nodes into queue and poping only two whenever needed
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def __init__(self):
        self.arr = deque()
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        if root.left == None and root.right == None:
            return True
        if root.left == None:
            return False
        if root.right == None:
            return False
        self.arr.append(root.left)
        self.arr.append(root.right)
        while len(self.arr) != 0:
            left = self.arr.popleft()
            right = self.arr.popleft()
            if left.val != right.val:
                return False
            if left.left != right.right:
                if left.left == None or right.right == None:
                    return False
                self.arr.append(left.left)
                self.arr.append(right.right)
            if left.right != right.left:
                if left.right == None or right.left == None:
                    return False
                self.arr.append(left.right)
                self.arr.append(right.left)
        return True
                
                
            
        