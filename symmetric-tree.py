# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None: return True
        return self.mirror(root.left,root.right)
    def mirror(self, left: Optional[TreeNode],right: Optional[TreeNode]):
        if left==None and right==None:
            return True
        if left==None or right==None: return False
        if left.val!=right.val:
            return False
        return self.mirror(left.left,right.right) and self.mirror(left.right,right.left)
         