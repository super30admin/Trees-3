"""
Time complexity is O(N/2) so aymptotically its O(N)
Space complexity is O(1)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_symmetric_R:
     def isMirror(self,left,right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val != right.val:
            return False
        #return(left.val==right.val) and self.isMirror(left.right,right.left) and self.isMirror(left.left,right.right)
        return self.isMirror(left.right,right.left) and self.isMirror(left.left,right.right)
    
    
     def isSymmetric(self, root: TreeNode) -> bool:
            if root is None:
                return True
            return self.isMirror(root.left,root.right)
    
   
    
    