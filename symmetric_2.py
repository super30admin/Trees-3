#time-n,space-h
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag=True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root,root)
    def helper(self,left,right):
        #base
        if left is None and right is None:
            return True
        #logic
        if left is None or right is None or left.val!=right.val:
            return False
        return (self.helper(left.left,right.right) and self.helper(left.right, right.left))