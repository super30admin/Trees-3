# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.checkNodes(root, root)

    def checkNodes(self, nodeLeft, nodeRight):
        # base case
        if not nodeLeft and not nodeRight:
            return True
        
        if not nodeLeft or not nodeRight:
            return False
            
        # logic

        if nodeLeft.val != nodeRight.val:
            return False

        return self.checkNodes(nodeLeft.left, nodeRight.right) and self.checkNodes(nodeLeft.right, nodeRight.left)
        