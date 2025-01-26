# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# dfs func take left and right r1 and r2
# if r1 and r2 not equal return False
# else - check left and right side 
# Left side- pass r1.left and r2.left in dfs 
# right side - same
# return left and right i.e. - atleast one F return F

# TC O(n), SC - O(1) + recursive stack
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        if root.left is None and root.right is None: return True
        
        def dfs(r1, r2):
            if not r1 and not r2: return True
            if r1 is None: return False
            if r2 is None: return False
            if r1.val != r2.val: return False

            return dfs(r1.left, r2.right) and dfs(r1.right, r2.left)   
        
        return dfs(root.left, root.right)
        