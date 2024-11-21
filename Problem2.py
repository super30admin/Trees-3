# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def helper(lnode, rnode):
            if lnode and not rnode:
                return False
            if rnode and not lnode:
                return False
            if not lnode and not rnode:
                return True
            if lnode.val != rnode.val:
                return False
        
            a = helper(lnode.left, rnode.right)
            b = helper(lnode.right, rnode.left)

            return a and b
        
        return helper(root.left, root.right)
