# Start with 2 trees left and right, give the if conditions and then recurse left.left and right.right, now recurse left.right and right.left
# TC: O(N)
# SC: O(H)
# Yes, this worked in leetcode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    Flag = True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        self.recurse(root.left, root.right)
        return self.Flag
    def recurse(self, leftNode, rightNode):
        if not leftNode and not rightNode:
            return
        if not leftNode or not rightNode:
            self.Flag = False
            return
        if leftNode.val != rightNode.val:
            self.Flag = False
            return
        self.recurse(leftNode.left, rightNode.right)
        self.recurse(leftNode.right, rightNode.left)
        
        
