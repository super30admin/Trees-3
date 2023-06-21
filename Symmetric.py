# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.IsSame(root.left, root.right)

    def IsSame(self, lft , rgt):
        if(lft == None and rgt == None):
            return True
        if(lft == None or rgt == None):
            return False

        if (lft.val != rgt.val):
            return False

        return self.IsSame(lft.left, rgt.right) and self.IsSame(lft.right, rgt.left)