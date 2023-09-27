# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root):
        def isMirror(L, R):
            if L and R:

                return L.val == R.val and isMirror(L.left, R.right) and isMirror(L.right, R.left)
            else:
                return L == R
        return isMirror(root, root)
            
        