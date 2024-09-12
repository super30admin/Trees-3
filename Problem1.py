# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity - O(n) n-nodes
#Space Complexity - O(h) h-height
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        return self.check(root.left,root.right)
    
    def check(self,left,right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val!=right.val:
            return False
        
        else:
            True
        return self.check(left.left,right.right) and self.check(left.right,right.left)
        
        
        
        