# TC : O(N)
# SC : O(H)
# Approach to solve this problem:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:            # Check if root is none
            return True
        
        return self.ismirror(root.left, root.right)     # calling the function
    
    def ismirror(self, leftroot, rightroot):
        if leftroot and rightroot:                      # If left and right is not null
            return leftroot.val == rightroot.val and self.ismirror(leftroot.left,rightroot.right) and self.ismirror(leftroot.right,rightroot.left) # Check leftroot value with rightroot value
        return leftroot == rightroot
        