// Time Complexity : O(n) 
// Space Complexity : O(h) 
                     //recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if root is None: return True
        
        return self.sym(root.left,root.right)
    
    def sym(self,a,b):
        
        
        if a== None and b==None:
            return True
        
        
        if (a== None or b== None or a.val !=b.val):
            return False
        
        
        return self.sym(a.left,b.right) and self.sym(a.right,b.left)
        
        
        