# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity -> O(N)
#Space Complexity -> O(1)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        t1 = root
        t2 = root
        def validate(t1,t2):
            if(t1 is None and t2 is None):
                return True
            if(t1 is None or t2 is None):
                return False
            if(t1.val!=t2.val):
                return False
            return validate(t1.left,t2.right) and validate(t1.right,t2.left)
        return validate(t1,t2)