
# // Time Complexity : O(n)
# // Space Complexity : O(h). h -> height of the tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
from typing import Optional
#  Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        self.isValid = True
        self.dfs(root.left, root.right)
            
        return self.isValid
    
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]):
        #base
        if(not left) and (not right):
            return
        
        if (not left) or (not right) or (left.val!= right.val):
            self.isValid = False
            return
        
        
        #logic
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)