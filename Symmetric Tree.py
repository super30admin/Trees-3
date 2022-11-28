# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
                
        # DFS
        if not root:
            return True

        def checkSymmetry(left, right):
            if not left and not right:
                return True
            elif not left or not right or left.val != right.val:
                return False
        
            return checkSymmetry(left.left, right.right) and checkSymmetry(left.right, right.left)
            
        return checkSymmetry(root.left, root.right)
