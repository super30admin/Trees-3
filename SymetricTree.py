# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC : O(n)
    # SC : O(h)
    def checkSymetry(self,leftSubTree : Optional[TreeNode], rightSubTree : Optional[TreeNode]) -> bool:
        if leftSubTree is None and rightSubTree is None:
            return True
        if leftSubTree is None or rightSubTree is None:
            return False
        if leftSubTree.val != rightSubTree.val:
            return False
        return self.checkSymetry(leftSubTree.left,rightSubTree.right) and self.checkSymetry(leftSubTree.right,rightSubTree.left)
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return self.checkSymetry(root.left,root.right)
        
        