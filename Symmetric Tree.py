# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC: O(n)
SC: O(n)
"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(leftTree, rightTree):
            if leftTree is None and rightTree is None :
                return True
            if leftTree is None or rightTree is None:
                return False
            
            return leftTree.val == rightTree.val and helper(leftTree.left, rightTree.right) and helper(rightTree.left, leftTree.right)
        return helper(root,root)
