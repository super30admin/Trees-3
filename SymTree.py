# Time Complexity o(N)
# Space Complexity o(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        
        self.lstack = []
        self.rstack = []
    
    
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        
        return self.isSymCheck(root.left,root.right)
        
        
    
    def isSymCheck(self,left,right):
        
        if left == None or right == None:
            return left == right
        
        if left.val != right.val:
            return False
        
        return self.isSymCheck(left.left , right.right) and self.isSymCheck(left.right, right.left)
        
        
        
        
        