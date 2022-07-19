# Definition for a binary tree node.
# class TreeNode:cc
#     def __init__(self, val=0, left=None, right=None):
#         self.val = vals
#         self.left = lefts
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        t1 = root
        t2 = root
        def validate(t1,t2):
            if(t1 is None and t2 is None):
                return True
            if(t1 is None or t2 is None):
                return False
            if(t1.val != t2.val):
                return False
            return validate(t1.left,t2.right) and validate(t1.right,t2.left)
        return validate(t1,t2)
        