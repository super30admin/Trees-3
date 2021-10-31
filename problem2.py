Time complexity O(n) and space O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        return self.helper(root.left,root.right)

    #Checking the left and right of left child with right and left child of right subtree
    def helper(self,l,r):
        
        if not l and not r:
            return True
        if not l or not r:
            return l==r 
        if l.val!=r.val:
            return False
        
        return self.helper(l.left,r.right) and self.helper(l.right,r.left)
