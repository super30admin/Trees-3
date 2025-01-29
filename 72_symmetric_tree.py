# Time complexity - O(n)
# Space complexity - O(h)

# Approach - With helper function that recursively compares left.left to right.right and 
# left.right to right.left and put conditions where these fail.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.dfs(root.left, root.right)
    
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        if left == None and right == None:
            return True
        if left == None or right == None:
            return False
        if left.val != right.val:
            return False
        case1 = self.dfs(left.left, right.right)
        case2 = self.dfs(left.right, right.left)
        return case1 and case2