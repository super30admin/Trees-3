# Time complexity: O(n)
# Space Complexity: O(H)  H is the height of the BST

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        l = root.left
        r = root.right
        return self.isMirror(l, r)
        
    def isMirror(self, l, r):
        if not l and not r:
            return True
        if not l or not r:
            return False
        if l.val != r.val:
            return False
        return self.isMirror(l.left,r.right) and self.isMirror(l.right,r.left)