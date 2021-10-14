'''
Time Complexity: O(n)
Space: o(n)
'''
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
        
        return self.isMirror(root.left,root.right)
    
    def isMirror(self,left,right):
        if left is None or right is None:
            return left==right
        
        elif left.val != right.val:
            return False
        
        return self.isMirror(left.left,right.right) and self.isMirror(left.right,right.left)
        
        