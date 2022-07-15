# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        l=[0]
        def sum_path(root,s):
            if root is None:
                return 
            
            if root.left is None and root.right is None:
                l[0]+=10*s+root.val
            
            sum_path(root.left,10*s+root.val)
            sum_path(root.right,10*s+root.val)
            
        sum_path(root,0)
        return l[0]
        