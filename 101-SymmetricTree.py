#Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        self.isValid = True
        
        def dfs(left ,right ):
            
            if left is None and right is None:
                return
            
            if (left is None or right is None or left.val != right.val):
                self.isValid = False
                return
            
            dfs(left.left,right.right)
            dfs(left.right,right.left)
            
        dfs(root.left,root.right)
        return self.isValid
        
        